import PyPDF2
import spacy

import Read_from_pdf
nlp = spacy.load('en_core_web_sm')
from spacy.matcher import PhraseMatcher
phrase_matcher = PhraseMatcher(nlp.vocab)


def extractKeySkillsFromJd(jobdiscription):
    keySkills={}
    keySkills=set()
    #extract key skills point form jobDiscription


    phrases = ['OOPs','Oops','oops','technical terminology','work independently','team work','research skills','English verbal skills','English written skills','Passion','talent','web applications','single page applications','CI/CD','automating cloud deployments','search engines','multi-server architectures','multi server architectures','high load applications','Scrum','Lean','work organized','analyse requirements','TDD','Jenkins','non-relational','functional programming','customer-oriented','communicate','fluently in English','business requirements','problem solving','different responsibilities','self-motivated','logical skills','analytical skills','verbal communication skills','communication skills','communication skills','written communication skills','source control tools','Software Development Life Cycle Process','Software Development Life Cycle Processes','WCF services','Demonstrated experience','innovations','innovative','client satisfaction','team player','English communication','design thinking skills','problem solving skills','troubleshooting skills','learn new technologies','requirement gathering','Performance tuning','Troubleshoot','debugging skills','Self-learning','analytical','mathematical skills','mathematical','learner','self-starter','programming skills','interpersonal skills','good learning capability','Self-driven','Algorithms','Data Structures','agile','modular architecture','layered architecture']
    patterns = [nlp(text) for text in phrases]

    phrase_matcher.add('AI', None, *patterns)
    doc1=nlp(jobdiscription)
    matched_phrases = phrase_matcher(doc1)
    
    for match_id, start, end in matched_phrases:
        string_id = nlp.vocab.strings[match_id]  
        span = doc1[start:end]             

        keySkills.add(span.text)
    return keySkills



def extractKeySkillsFromCv(txt,jobDiscription):
    matchingSkillSet={}
    
    matchingSkillSet=set()
    
    keySkills=list(extractKeySkillsFromJd(jobDiscription))
    patterns = [nlp(text) for text in keySkills]

    phrase_matcher.add('AI', None, *patterns)
    doc1=nlp(txt)
    matched_phrases = phrase_matcher(doc1)
    
    for match_id, start, end in matched_phrases:
        string_id = nlp.vocab.strings[match_id]  
        span = doc1[start:end]             

        matchingSkillSet.add(span.text)
    if len(keySkills)!=0:
        matchedPercetage=(len(matchingSkillSet)/len(keySkills))*100
    else:matchedPercetage=0
    return matchedPercetage



