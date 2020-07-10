import spacy
import re
nlp = spacy.load('en_core_web_sm')
import emailAndContact
import tech_stack
import PyPDF2
import os

from spacy.matcher import PhraseMatcher
from spacy.matcher import Matcher
phrase_matcher = PhraseMatcher(nlp.vocab)
matcher = Matcher(nlp.vocab)

def extract_full_name(nlp_doc):
     names=[]
     pattern = [{'POS': 'PROPN'},{'POS': 'PROPN'}, {'POS': 'PROPN'}]
     matcher.add('FULL_NAME', None, pattern)
     matches = matcher(nlp_doc)
     for match_id, start, end in matches:
         span = nlp_doc[start:end]
         names.append(span.text)
     print(most_common(names))
     return names

def most_common(lst):
    return max(set(lst), key=lst.count)


with open('resume.pdf','rb') as pdf_file, open('sample.txt', 'w') as text_file:
    read_pdf = PyPDF2.PdfFileReader(pdf_file)
    number_of_pages = read_pdf.getNumPages()
    for page_number in range(number_of_pages):   # use xrange in Py2
        page = read_pdf.getPage(page_number)
        page_content = page.extractText()
        text_file.write(page_content)

mytxt = open('sample.txt')
txt=mytxt.read()
#print(txt)
about_doc=nlp(txt)

print(extract_full_name(about_doc))
print(emailAndContact.findContact(txt))
print(emailAndContact.findEmail(txt))
print(tech_stack.techno_stack(txt))








pdf_file.close()
text_file.close()
os.remove('sample.txt')


    
