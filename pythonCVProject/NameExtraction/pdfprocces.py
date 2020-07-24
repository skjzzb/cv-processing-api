from pdfminer.layout import LAParams
from pdfminer.converter import PDFPageAggregator
from pdfminer.pdfinterp import PDFResourceManager
from pdfminer.pdfinterp import PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.layout import LTTextBoxHorizontal
import io

def parsedocument(document):
    # convert all horizontal text into a lines list (one entry per line)
    # document is a file stream
    lines = []
    rsrcmgr = PDFResourceManager()
    laparams = LAParams()
    device = PDFPageAggregator(rsrcmgr, laparams=laparams)
    interpreter = PDFPageInterpreter(rsrcmgr, device)
    for page in PDFPage.get_pages(document):
            interpreter.process_page(page)
            layout = device.get_result()
            for element in layout:
                if isinstance(element, LTTextBoxHorizontal):
                    lines.extend(element.get_text().splitlines())
    return lines
with io.open('Ramamurthi.pdf','rb') as fs, open('demo1.txt','w') as text_file :
    lines=parsedocument(fs)
    for line in lines:
        text_file.write(line)
text_file=open('demo1.txt','r')
text=text_file.read()
text=text.replace('            ',' ')
print(text)
    
    

            
           
