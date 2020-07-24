import PyPDF2
import spacy
nlp = spacy.load('en_core_web_sm')
from spacy.matcher import PhraseMatcher
phrase_matcher = PhraseMatcher(nlp.vocab)

def techno_stack(txt):
    tech_stack={}
    tech_stack=set()

    phrases = ['Python','MySql','NodeJs','ExpressJs','Core Java','Advance Java','J2EE','Spring','Hibernate','Microservices','SQL','C++','cpp','DevOps','Kubernetes','Docker','ReactJS','ReactJs','Angular','HTML','CSS','.Net','Asp.net','Machine Learning', 'Javascript']
    patterns = [nlp(text) for text in phrases]

    phrase_matcher.add('AI', None, *patterns)
    doc1=nlp(txt)
    matched_phrases = phrase_matcher(doc1)
    
    for match_id, start, end in matched_phrases:
        string_id = nlp.vocab.strings[match_id]  
        span = doc1[start:end]             

        tech_stack.add(span.text)

    return tech_stack

