import re
import numpy as np 
def findContact(data):
    pattern=r'\d\d\d\d\d\d\d\d\d\d'
    contact_no=[]
    for match in re.findall(pattern,data):
        contact_no.append(match)
    
    return unique(contact_no)

def findEmail(data):
    email=[]
    for match in re.findall('\S+@\S+', data) :
         email.append(match)
    
    return unique(email)


def unique(list1): 
    x = np.array(list1) 
    return (np.unique(x)) 