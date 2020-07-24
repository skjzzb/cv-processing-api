import requests
headers={'Content-type':'application/json', 'Accept':'application/json'}
url = 'https://cv-processing-api.herokuapp.com/v1/vacancy?sort=avalible'
vacancies = requests.get(url)

def getVacancies():
    url = 'https://cv-processing-api.herokuapp.com/v1/vacancy?sort=avalible'
    vacancies1 = requests.get(url)
    return vacancies1

#print(len(x.json()))
#for i in range(len(x.json())):
   # vacancyId=x.json()[i].get('vacancyId')
    #candidate_data={
    #"candidateName": "Sahdev singh",
    #"contactNo": "9954208770",
    #"email": "sahdev@gmail.com",
   # "technologyStack": "Java,Mysql,Nosql",
    #"reqMatchingPercent": 100,
    #"yearOfExperience": 1
   # }
   # url2='https://cv-processing-api.herokuapp.com/v1/candidiate/{}'.format(vacancyId)
    #y=requests.put(url2,json=candidate_data,headers=headers)

