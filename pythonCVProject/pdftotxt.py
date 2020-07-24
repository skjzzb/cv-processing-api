import io
import os
import nltk


from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfpage import PDFPage


def convert_pdf_to_txt(path):
    '''Convert pdf content from a file path to text

    :path the file path
    '''
    rsrcmgr = PDFResourceManager()
    
    laparams = LAParams()

    with io.StringIO() as retstr:
        with TextConverter(rsrcmgr, retstr,laparams=laparams) as device:
            with open(path, 'rb') as fp:
                interpreter = PDFPageInterpreter(rsrcmgr, device)
                password = ""
                maxpages = 0
                caching = True
                pagenos = set()

                for page in PDFPage.get_pages(fp,
                                              pagenos,
                                              maxpages=maxpages,
                                              password=password,
                                              caching=caching,
                                              check_extractable=True):
                    interpreter.process_page(page)

                return retstr.getvalue()


if __name__ == "__main__":
    print(convert_pdf_to_txt('Ranjan_CV.pdf'))