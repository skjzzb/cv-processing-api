import io
import re
import spacy
nlp = spacy.load('en_core_web_sm')

from spacy.matcher import PhraseMatcher
from spacy.matcher import Matcher
phrase_matcher = PhraseMatcher(nlp.vocab)
matcher = Matcher(nlp.vocab)
matcher1 = Matcher(nlp.vocab)

def hasNumbers(inputString):
    return any(char.isdigit() for char in inputString)
def most_common(lst):
    return( max(lst, key=lst.count))

def listToString(s):  
    str1 = " "  
    return (str1.join(s)) 

def extract_full_name(nlp_doc,no_of_word):
    names=[]
    if no_of_word>=3 :
        pattern = [{'POS': 'PROPN'},{'POS': 'PROPN'}, {'POS': 'PROPN'}]
        pattern1 = [{'POS': 'PROPN'},{'POS': 'PROPN'}, {'POS': 'NOUN'}]
        pattern2 = [{'POS': 'PROPN'},{'POS': 'NOUN'}, {'POS': 'NOUN'}]
        matcher.add('FULL_NAME', None, pattern,pattern1,pattern2)
        matches = matcher(nlp_doc)
        for match_id, start, end in matches:
            span = nlp_doc[start:end]
            names.append(span.text)
    if no_of_word==2:
        pattern = [{'POS': 'PROPN'},{'POS': 'PROPN'}]
        pattern1 = [{'POS': 'PROPN'},{'POS': 'NOUN'}]
        matcher.add('FULL_NAME', None, pattern,pattern1)
        matches = matcher(nlp_doc)
        for match_id, start, end in matches:
            span = nlp_doc[start:end]
            names.append(span.text)
    if no_of_word==1 :
        pattern = [{'POS': 'PROPN'}]
        pattern1 = [{'POS': 'NOUN'}]
        matcher.add('FULL_NAME', None, pattern,pattern1)
        matches = matcher(nlp_doc)
        for match_id, start, end in matches:
            span = nlp_doc[start:end]
            names.append(span.text)
    return listToString(names)



def name_from_name_keyword(Lines):
    from_name_keyword=[]
    full_name_from_name_keyword=""
    for line in Lines: 
        if "Name" in line:
                    txt= (line.strip())
                    lst=(re.split(": |:-|-",txt))
                    if(len(lst)>1 and lst[0].strip()=="Name") :
                        from_name_keyword.append(lst[1].strip())
                
    if(len(from_name_keyword)>0):
        full_name_from_name_keyword=most_common(from_name_keyword)
    return full_name_from_name_keyword

def from_first_line(Lines):
    full_name_from_first_line=""
    if "resume" in Lines[0].strip().lower() or "curriculum" in Lines[0].strip().lower() or "vitae" in Lines[0].strip().lower():
        print("inside")
        str=Lines[1].strip()
    else : str=Lines[0].strip()
    name=[]
    if not (',' or'-'or '@'or ':' or ';')in str and hasNumbers(str)==False:
            doc = nlp(str)
            for token in doc:
                print(token.text, token.pos_, token.tag_)
                if token.pos_=="PROPN" or token.pos_=="NOUN": 
                    name.append(token)
            print(name)
            full_name_from_first_line=extract_full_name(doc,len(name))
    return full_name_from_first_line
    



