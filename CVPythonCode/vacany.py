import requests

url = 'https://cv-processing-api.herokuapp.com/v1/vacancy'
x = requests.get(url)
print(x.json()[0].get('vacancyId'))
vacancyId=x.json()[0].get('vacancyId')
headers={'Content-type':'application/json', 'Accept':'application/json'}
url2='https://cv-processing-api.herokuapp.com/v1/candidiate/{}'.format(vacancyId)

candidate_data={
  "candidateName": "Sahdev singh",
  "contactNo": "9954208770",
  "email": "sahdev@gmail.com",
  "reqMatchingPercent": 100,
  "technologyStack": "Java,Mysql,Nosql"
}
y=requests.put(url2,json=candidate_data,headers=headers)
print(y.text)