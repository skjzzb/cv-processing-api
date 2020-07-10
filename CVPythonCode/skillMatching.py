import requests
import tech_stack
import Read_from_pdf

def skillMatching(technologyStack,JD):
    jobDescription=JD.split(',')
    matchedTechnology=0
    for jd in jobDescription:
        if any(jd in tech for tech in technologyStack):
            matchedTechnology+=1
    matchingPersentage=(matchedTechnology/len(jobDescription))*100
    return matchingPersentage


#lines=Read_from_pdf.read_text_by_lines('/home/sahdev/ProjectCV/python /python/CV/Mayur Yadav Resume (1).pdf')
#text_file=open('demo.txt')
#txt=text_file.read()
#technologyStack=tech_stack.techno_stack(txt)


#url = 'https://cv-processing-api.herokuapp.com/v1/vacancy?sort=avalible'
#vacancies = requests.get(url)
#for i in range(len(vacancies.json())):
    #print(skillMatching(technologyStack,vacancies.json()[i].get('jd')))





