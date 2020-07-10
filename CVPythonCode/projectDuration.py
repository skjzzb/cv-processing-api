import Read_from_pdf
import re


def parseText(filepath):
    Lines=Read_from_pdf.read_text_by_lines(filepath)
    totalLengthOfDocument=len(Lines)
    experienceLine=-1
    projectLine=-1
    for i in range(totalLengthOfDocument):
        if 'WORK EXPERIENCE' in Lines[i] or 'EXPERIENCE' in Lines[i]:
            experienceLine=i
        if 'PROJECTS' in Lines[i] or 'PROJECT' in Lines[i]:
            projectLine=i
    
    if projectLine>experienceLine:
        for i in range(projectLine,len(Lines)):
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
                Lines[i]=Lines[i].replace(match,' ')
    else:
        for i in range(projectLine,experienceLine-1):
            Lines[i]=Lines[i].replace('+',' ')
            Lines[i]=Lines[i].replace('.0',' ')
            Lines[i]=Lines[i].replace('.',' ')
            Lines[i]=Lines[i].replace('–',' ')
            Lines[i]=Lines[i].replace('-',' ')
            Lines[i]=Lines[i].replace('to',' ')
            Lines[i]=Lines[i].replace('`',' ')
            Lines[i]=Lines[i].replace('‘',' ')
            Lines[i]=Lines[i].replace('Years','years')
            Lines[i]=Lines[i].replace('YEARS','years')
            
            Lines[i]=Lines[i].replace('  ',' ')
            Lines[i]=Lines[i].replace('  ',' ')
            pattern=r'[A-Z][a-z]+ \d{2,4} [A-Z][a-z]+ \d{2,4}'
            for match in re.findall(pattern,Lines[i]):
                Lines[i]=Lines[i].replace(match,' ')
          
    return Lines
