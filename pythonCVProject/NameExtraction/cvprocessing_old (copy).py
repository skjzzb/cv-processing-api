
import pickle
import PyPDF2
import random
from pdfminer.layout import LAParams
from pdfminer.converter import PDFPageAggregator
from pdfminer.pdfinterp import PDFResourceManager
from pdfminer.pdfinterp import PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.layout import LTTextBoxHorizontal
import io
train_data=pickle.load(open('train_data.pkl','rb'))
#print(train_data[0])
import spacy
nlp = spacy.load('en_core_web_sm')


def train_model(train_data):
    if 'ner' not in nlp.pipe_names:
        ner=nlp.create_pipe('ner')
        nlp.add_pipe(ner,last=True)
    for _,annotation in train_data:
        for ent in annotation['entities']:
            ner.add_label(ent[2])
    other_pipes = [pipe for pipe in nlp.pipe_names if pipe != 'ner']
    with nlp.disable_pipes(*other_pipes):  # only train parser
        optimizer = nlp.begin_training()
        for itn in range(10):
            random.shuffle(train_data)
            losses = {}
            index =0
           
            for text,annotations in train_data:
                try:
                    nlp.update(
                        [text],
                        [annotations],
                        drop=0.2,
                        sgd=optimizer,
                        losses=losses
                    )
                except Exception as e:
                    pass
            #print(losses)
                
# res_model=train_model(train_data)
# res_model.to_disk('resume_model')
nlp_model=spacy.load('nlp_model')  ###############
#doc=nlp_model(train_data[0][0])
#for ent in doc.ents:
    #print(f'{ent.label_.upper():{30}}-{ent.text}')

#with open('Ramamurthi.pdf','rb') as pdf_file, open('sample.txt', 'w') as text_file:
 #   read_pdf = PyPDF2.PdfFileReader(pdf_file)
  #  number_of_pages = read_pdf.getNumPages()
   # for page_number in range(number_of_pages):   # use xrange in Py2
    #    page = read_pdf.getPage(page_number)
     #   page_content = page.extractText()
      #  text_file.write(page_content)

#mytxt = open('sample.txt')
#text=mytxt.read()
#print(text)
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
with io.open('Ranjan_CV.pdf','rb') as fs, open('demo1.txt','w') as text_file :
    lines=parsedocument(fs)
    for line in lines:
        text_file.write(line)
text_file=open('demo1.txt','r')
text=text_file.read()
#text=text.replace('  ',' ')

text1=text.replace('Name:',' ')
text1=text1.replace('-',' ')
text1=text1.replace('Name',' ')
text1=text1.replace('CURRICULUM  VITAE','')
text1=text1.replace('Resume',' ')
text1=text1.replace('RESUME',' ')
text1=text1.replace(':',' ')
tx=" ".join(text1.split('\n'))
#print(tx)
doc=nlp_model(tx)
print(f'{doc.ents[0].label_.upper():{30}}-{doc.ents[0].text}')
#for ent in doc.ents:
   # print(f'{ent.label_.upper():{30}}-{ent.text}')