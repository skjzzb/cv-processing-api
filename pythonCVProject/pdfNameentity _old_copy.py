import spacy 
import PyPDF2
nlp = spacy.load('en_core_web_sm') 
from spacy.matcher import PhraseMatcher
from spacy.matcher import Matcher
phrase_matcher = PhraseMatcher(nlp.vocab)
matcher1 = Matcher(nlp.vocab)
matcher = Matcher(nlp.vocab)


with open('Ranjan_CV.pdf','rb') as pdf_file, open('sample.txt', 'w') as text_file:
    read_pdf = PyPDF2.PdfFileReader(pdf_file)
    number_of_pages = read_pdf.getNumPages()
    for page_number in range(number_of_pages):  
        page = read_pdf.getPage(page_number)
        page_content = page.extractText()
        text_file.write(page_content)

mytxt = open('sample.txt')
txt=mytxt.read()


nlp_doc=nlp(txt)
def extract_two_pos_name(nlp_doc):
        names=[]
        pattern1 = [{'POS': 'PROPN'},{'POS': 'PROPN'}]
        matcher1.add('FULL_NAME', None, pattern1)
        matches1 = matcher1(nlp_doc)
        for match_id, start, end in matches1:
            span = nlp_doc[start:end]
            print(span.text)
            entities= nlp(span.text)
            if entities[0].ent_type_ == 'PERSON' and entities[1].ent_type_ == 'PERSON'  : 
                    names.append(entities)

        print((names))
        return (mst_common(names))

def extract_full_name(nlp_doc):
     names=[]
     pattern = [{'POS': 'PROPN'},{'POS': 'PROPN'}, {'POS': 'PROPN'}]
     matcher.add('FULL_NAME', None, pattern)
     matches = matcher(nlp_doc)
     for match_id, start, end in matches:
         span = nlp_doc[start:end]
         entities= nlp(span.text)
         if entities[0].ent_type_ == 'PERSON' and entities[1].ent_type_ == 'PERSON'and entities[2].ent_type_ == 'PERSON'  :
                    names.append(entities)
        
     print((names))
     return (mst_common(names))

def mst_common(lst):

    return( max(lst, key=lst.count))


print(extract_two_pos_name(nlp_doc))


