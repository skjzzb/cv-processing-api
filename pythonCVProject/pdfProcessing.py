from pdfminer.layout import LAParams
from pdfminer.converter import PDFPageAggregator
from pdfminer.pdfinterp import PDFResourceManager
from pdfminer.pdfinterp import PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.layout import LTTextBoxHorizontal
import io
import re

def parsedocument(document):
    lines = []
    rsrcmgr = PDFResourceManager()
    laparams = LAParams()
    device = PDFPageAggregator(rsrcmgr, laparams=laparams)
    interpreter = PDFPageInterpreter(rsrcmgr, device)
    for page in PDFPage.get_pages(document):
            interpreter.process_page(page)
            layout = device.get_result()
            for element in layout:
                if isinstance(element, LTTextBoxHorizontal):
                    lines.extend(element.get_text().splitlines())
    return lines


import spacy
import re

nlp = spacy.load('en_core_web_sm')
import emailAndContact
import tech_stack
import PyPDF2
import pdfminer
import os

import requests
headers={'Content-type':'application/json', 'Accept':'application/json'}

from spacy.matcher import PhraseMatcher
from spacy.matcher import Matcher
phrase_matcher = PhraseMatcher(nlp.vocab)
matcher = Matcher(nlp.vocab)
matcher1 = Matcher(nlp.vocab)

# with open('Ranjan_CV.pdf','rb') as pdf_file, open('sample.txt', 'w') as text_file:
#     read_pdf = PyPDF2.PdfFileReader(pdf_file)
#     number_of_pages = read_pdf.getNumPages()
#     for page_number in range(number_of_pages):   # use xrange in Py2
#         page = read_pdf.getPage(page_number)
#         page_content = page.extractText()
#         text_file.write(page_content)

with io.open('CV/Resume_Harish_N.pdf','rb') as fs, io.open('sample.txt', 'w') as text_file:
    lines=parsedocument(fs)
    for line in lines:
        if not line.isspace():
          text_file.write(line+ '\n')
    text_file.close()

mytxt = open('demo.txt')
txt=mytxt.read()
# with io.open('sample1.txt', 'w') as text_file:
#     rc = re.compile(r"\n{2,}")  # two and more new lines
#     string_without_extra_new_lines = re.sub(rc,"\n", txt)
#     text_file.write(string_without_extra_new_lines)
about_doc=nlp(txt)


def extract_full_name(nlp_doc):
     names=[]
     full_name=''
     pattern = [{'POS': 'PROPN'},{'POS': 'PROPN'}, {'POS': 'PROPN'}]
     matcher.add('FULL_NAME', None, pattern)
     matches = matcher(nlp_doc)
     for match_id, start, end in matches:
         span = nlp_doc[start:end]
         names.append(span.text)
    #  print(names)
     if len(names)>0 :
        temp_var=str((most_common(names)))
        if not ('.'or','or':'or';'or'-')in temp_var :
            full_name=temp_var
    #  print(full_name)  
     return full_name

def extract_two_pos_name(nlp_doc):
        two_pos_name=""
        # for ent in nlp_doc:
        #     print(ent.text,ent.ent_type_)
        names=[]
        pattern1 = [{'POS': 'PROPN'},{'POS': 'PROPN'}]#, {'POS': 'PROPN'}]
        matcher1.add('FULL_NAME', None, pattern1)
        matches1 = matcher1(nlp_doc)
        for match_id, start, end in matches1:
            span = nlp_doc[start:end]
            # print(span.text)            
            entities=nlp(span.text)
            #print(entities,  entities.ent_type_)
            # for X in entities:
                # if X.ent_type_ == 'PERSON':
            # print(entities[0],  entities[0].ent_type_,  entities[1],  entities[1].ent_type_)
            # #   print(ent, ent.ent_type_)
            if entities[0].ent_type_ == 'PERSON' and entities[1].ent_type_ == 'PERSON'  :
                    # print(entities) 
                    names.append(entities)
        # print((names))
        if len(names)>0 :
            temp_var=str((most_common(names)))
            if not ('.'or','or':'or';'or'-')in temp_var :
                    two_pos_name=temp_var
        return two_pos_name

def most_common(lst):

    return( max(lst, key=lst.count))

def check(three_position_name, two_position_name): 
    if (three_position_name.find (two_position_name)==-1):  
        return two_position_name
    else: 
        return  three_position_name

def listToString(s):  
    str1 = " "  
    return (str1.join(s)) 


# three_position_name=extract_full_name(about_doc)
# two_position_name=extract_two_pos_name(about_doc)
candidate_contact=emailAndContact.findContact(txt)
# candidate_email=emailAndContact.findEmail(txt)
# candidate_tech_stack=tech_stack.techno_stack(txt)
# print((three_position_name))
# print((two_position_name))
# candidate_name=check(str(three_position_name),str(two_position_name))
# print(candidate_name)
# print(candidate_email)
# print(candidate_contact)
# print(candidate_tech_stack)


# if  len(candidate_contact)==2:
#         contactNo=candidate_contact[0]+"/"+candidate_contact[1]
# else :
#         contactNo=candidate_contact[0]


# candidate_data={
#     'candidateName':candidate_name,
#     # 'candidate_email':candidate_email,
#     'contactNo':contactNo,
#     'technologyStack':listToString(candidate_tech_stack)
# }

# print(candidate_data)
# url = 'https://cv-processing-api.herokuapp.com/v1/candidiate'
# x = requests.post(url, json=candidate_data,headers=headers)
# print(x.text)









# pdf_file.close()
# text_file.close()
# os.remove('sample.txt')


    # about_doc=nlp(lines[7])
    # extract_two_pos_name(about_doc)

    
