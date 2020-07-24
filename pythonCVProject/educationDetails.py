import Read_from_pdf
import re

def lastYearOfEducation(filepath):
    Lines=Read_from_pdf.read_text_by_lines(filepath)
    totalLengthOfDocument=len(Lines)
    educationSectionPosition=-1
    for i in range(totalLengthOfDocument):
        if 'Education' in Lines[i] or 'EDUCATION' in Lines[i]:
            educationSectionPosition=i


    higherEducationYear=[]
    if educationSectionPosition!=-1:
        for i in range(educationSectionPosition,educationSectionPosition+4):
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
            pattern=r'[A-Z][a-z]+ \d{2,4} [A-Z][a-z]+ \d{2,4}'
            for match in re.findall(pattern,Lines[i]):
                higherEducationYear.append(match)
        years=[]
        for highEduYear in higherEducationYear:
            
            patternForYear=r'\d{2,4}'
            
            for match in re.findall(patternForYear,highEduYear):
                years.append(match)
        if len(years)!=0:
            return years[1]
        else:
            return 0
    else:
        return 0
    