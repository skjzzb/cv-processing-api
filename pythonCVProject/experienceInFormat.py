import Read_from_pdf
import re
import datetime
import educationDetails
import projectDuration

def experience(filepath):
    x = datetime.datetime.now()

    Lines=projectDuration.parseText(filepath)
    Lines1=[]
    for i in range(len(Lines)):
        Lines[i]=Lines[i].replace('+','')
        Lines[i]=Lines[i].replace('.0','')
        Lines[i]=Lines[i].replace('.','')
        Lines[i]=Lines[i].replace('–',' ')
        Lines[i]=Lines[i].replace('-',' ')
        Lines[i]=Lines[i].replace('to',' ')
        Lines[i]=Lines[i].replace('`','')
        Lines[i]=Lines[i].replace('‘','')
        Lines[i]=Lines[i].replace('Years','years')
        Lines[i]=Lines[i].replace('YEARS','years')       
        Lines[i]=Lines[i].replace('  ',' ')
        Lines[i]=Lines[i].replace('  ',' ')
        Lines1.append(Lines[i])

    pattern=r'[A-Z][a-z]+ \d{2,4} [A-Z][a-z]+ \d{2,4}'
    pattern1=r'Since [A-Za-z]+ \d{2,4}'
    pattern2=r'[A-Za-z]+ \d{2,4} current|[A-Za-z]+ \d{2,4} Till Date|[A-Za-z]+ \d{2,4} Present|[A-Za-z]+ \d{2,4} onwards'
    experiences=[]
    tillCurrent=[]
    totalExperience=0
    for line in Lines1:
        for match in re.findall(pattern,line):
            experiences.append(match)
        for match in re.findall(pattern1,line):
            tillCurrent.append(match)
        for match in re.findall(pattern2,line):
            tillCurrent.append(match)

    for ep in experiences:
        
        patternForYear=r'\d{2,4}'
        years=[]
        for match in re.findall(patternForYear,ep):
            years.append(match)
        if len(years)!=0:
            if int(educationDetails.lastYearOfEducation(filepath))<=int(years[0]):
                totalExperience+=int(years[1])-int(years[0])
            

    patternForLastYear=r'\d{2,4}'
    lastExperience=[]
    if len(tillCurrent)!=0:
        for match in re.findall(patternForLastYear,tillCurrent[0]):
            lastExperience.append(match)

    if len(lastExperience)!=0:
        if int(lastExperience[0])<100:
            totalExperience+=int(x.strftime("%y"))-int(lastExperience[0])
        else:
            totalExperience += x.year-int(lastExperience[0])
    return totalExperience