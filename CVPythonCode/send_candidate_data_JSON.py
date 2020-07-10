import emailAndContact
import tech_stack
import Name_entity_extraction
import Read_from_pdf
import os 
import yearOfExperience
import requests
import skillMatching
import updatedVacancy

headers={'Content-type':'application/json', 'Accept':'application/json'}
def listToString(s):  
    str1 = " "  
    return (str1.join(s)) 

def send(pdf_file):
        Lines=""
        candidate_name=""
        candidate_contact=[]
        candidate_email=[]
        candidate_tech_stack=[]
        Lines=Read_from_pdf.read_text_by_lines(pdf_file)
        text_file=open('demo.txt')
        candidate_name=Name_entity_extraction.name_entity_extraction(Lines,text_file)
        text_file=open('demo.txt')
        txt=text_file.read()
        candidate_contact=emailAndContact.findContact(txt)
        candidate_email=emailAndContact.findEmail(txt)
        candidate_tech_stack=tech_stack.techno_stack(txt)
        candidate_experience=yearOfExperience.getExperience(pdf_file)
        text_file.close()
        os.remove(pdf_file)
        os.remove('sample.txt')
        os.remove('demo.txt')
        emailAddress=''
        if len(candidate_email)!=0:
                emailAddress=candidate_email[0]
        contactNo=""
        if  len(candidate_contact)==2 and len(candidate_contact)!=0:
                contactNo=candidate_contact[0]+"/"+candidate_contact[1]
        else :
                contactNo=candidate_contact[0]

        candidate_data={
        "candidateName":candidate_name,
        "email":emailAddress,
        "contactNo":contactNo,
        "technologyStack":listToString(candidate_tech_stack),
        "reqMatchingPercent":0,
        "yearOfExperience":candidate_experience
        }

        print(candidate_data)

        vacancies=updatedVacancy.getVacancies()
        for i in range(len(vacancies.json())):
                reqMatchingPercent=skillMatching.skillMatching(candidate_tech_stack,vacancies.json()[i].get('jd'))
                candidate_reqMatching={"reqMatchingPercent":reqMatchingPercent}
                candidate_data.update(candidate_reqMatching)
                print(candidate_data)
                url2='https://cv-processing-api.herokuapp.com/v1/candidiate/{}'.format(vacancies.json()[i].get('vacancyId'))
                y=requests.put(url2,json=candidate_data,headers=headers)





