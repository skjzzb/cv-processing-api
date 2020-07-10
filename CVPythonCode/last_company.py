import Read_from_pdf
import pdfplumber
import io
import re
import spacy

Read_from_pdf.read_text_by_lines('/home/sahdev/ProjectCV/python /python/CV/meetsunilkrgmailDotcom.pdf')
text_file =open('sample.txt','r') 
lines=text_file.readlines()
Lines=[]

lineNumber=-1



for i in range(len(lines)):
    lines[i]=lines[i].replace("-"," ")
    lines[i]=lines[i].replace("\'"," ")
    lines[i]=lines[i].replace("   "," ")
    lines[i]=lines[i].replace("  "," ")
    if ' till date' in lines[i] or ' Till Date' in lines[i] or ' Till date' in lines[i] or ' TILL DATE' in lines[i] :
           
           lineNumber=i
           break
    elif ' till now' in lines[i] or ' Till Now' in lines[i] or ' Till now' in lines[i] :
        # if  'date' in line:
          
           lineNumber=i
           break
    elif ' Present ' in lines[i] or ' present ' in lines[i] or ' PRESENT ' in lines[i]:
        # if  'date' in line:
           
           lineNumber=i
           break
    elif ' Currently' in lines[i] or ' currently' in lines[i] or ' current' in lines[i] or ' Current' in lines[i]:
        # if  'date' in line:
           
           lineNumber=i
           break
    elif ' onwords' in lines[i] or ' Onwards' in lines[i] or ' onward' in lines[i] or ' Onward' in lines[i]:
        # if  'date' in line:
           
           lineNumber=i
           break

# exp_text=[ t for t in lines if ' ' in t ]
#nlp=spacy.load('en_core_web_sm')
companyDetails=""
isTrue=True
#if ' Pvt. Ltd' in lines[lineNumber] or 'Bangalore' in lines[lineNumber] or 'Pune' in lines[lineNumber] or 'PUNE' in lines[lineNumber] or 'org' in lines[lineNumber] or 'PVT. LTD' in lines[lineNumber] or 'Ltd' in lines[lineNumber] or 'Technologies' in lines[lineNumber] or 'Technology' in lines[lineNumber]:
    
    #companyDetails=lines[lineNumber]
    #isTrue=False
       
if lineNumber!=-1 and isTrue:
    
    for i in range(lineNumber-2,lineNumber+2):
        

        if ' Pvt. Ltd' in lines[i] or 'Pune' in lines[i] or 'PUNE' in lines[i] or 'org' in lines[i] or 'PVT. LTD' in lines[i] or 'Ltd' in lines[i] or 'Technologies' in lines[i] or 'Technology' in lines[i]:
            
            companyDetails=lines[i]
            break

if 'University' in companyDetails:
    companyDetails=""


print(companyDetails)
# txt=([line for line in lines if 'Ramamurthi' in line]) 
# print(txt)