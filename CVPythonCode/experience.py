
import pdfplumber
import io
import re
text_file = open('sample.txt', 'w') 
pdf = pdfplumber.open('./CV/Nikhil-Prashant-Sonpawale.pdf')
for page in range(len(pdf.pages)):
    text_file.write(pdf.pages[page].extract_text())
text_file.close()
text_file = open('sample.txt', 'r') 
txt=text_file.read()

exp_text=([ t for t in txt.split('. ') if 'experience' in t and ('years' in t or 'Years' in t)])


exp_text=str(exp_text)
exp_text=exp_text.replace('\\n','')
exp_text=exp_text.replace('\\','')
exp_text=exp_text.replace('Years','years')
exp_text=exp_text.replace('YEARS','years')
print(exp_text)

pattern0=r"\d{1,2}\\*\.\d*\+\syears"
pattern1=r"\d{1,2}\\*\.\d\syears"
pattern2=r"\d{1,2}\\*\+\syears"
pattern3=r"\d{1,2}\syears"

patternList=[pattern0,pattern1,pattern2,pattern3]
gotMatch = False
for pattern in patternList:
    experience = re.findall(pattern,exp_text)
    if experience:
         gotMatch = True
         break



    
if len(experience)>1:
    print(experience[0])
else: print(experience)



tx1=txt.replace('+','')
tx1=tx1.replace('.0','')
tx1=tx1.replace('.','')
tx1=tx1.replace('–',' ')
tx1=tx1.replace('-',' ')
tx1=tx1.replace('to',' ')
tx1=tx1.replace('`','')
tx1=tx1.replace('‘','')
tx1=tx1.replace('Years','years')
tx1=tx1.replace('YEARS','years')
tx1=" ".join(tx1.split('\n'))
tx1=tx1.replace('  ',' ')
tx1=tx1.replace('  ',' ')
# print(tx1)
pattern=r'[A-Za-z]+ \d{2,4} [A-Za-z]+ \d{2,4}'
experience=[]

for match in re.findall(pattern,tx1):
    experience.append(match)
print(experience)