
import Read_from_pdf
import Name_extraction
import nlp_model
import spacy
nlp = spacy.load('en_core_web_sm')
nlp_model=spacy.load('nlp_model')
import NameExtraction.cvprocessing_using_trained_model


def check(string, substring): 
    if (string.find (substring)==-1):  
        return False
    else: 
        return  True

def name_entity_extraction(Lines,text_file):
    print(Lines[0].strip().lower()) 
    
    full_name_from_first_line=""
    full_name_from_first_line=Name_extraction.from_first_line(Lines)
    if (full_name_from_first_line!=""):
        print("full_name_from_first_line :"+full_name_from_first_line) 

    full_name_from_name_keyword=""
    full_name_from_name_keyword=Name_extraction.name_from_name_keyword(Lines)
    if (full_name_from_name_keyword!=""):
        print("full_name_from_name_keyword :"+full_name_from_name_keyword) 

   
    full_ame_from_trained_model=""
    full_ame_from_trained_model=NameExtraction.cvprocessing_using_trained_model.Name_from_trained_model(nlp_model,text_file)
    if (full_ame_from_trained_model!=""):
        print("full_ame_from_trained_model : "+full_ame_from_trained_model) 
   
    candidate_name=""

    if (full_name_from_name_keyword !="" and full_name_from_first_line !="" and check(full_name_from_name_keyword.lower().strip(),full_name_from_first_line.lower().strip())) or (full_ame_from_trained_model !="" and full_name_from_name_keyword !=""  and check(full_name_from_name_keyword.lower().strip(),full_ame_from_trained_model.lower().strip())) or (full_ame_from_trained_model !="" and full_name_from_first_line !="" and check(full_name_from_first_line.lower().strip(),full_ame_from_trained_model.lower().strip())):
        if full_name_from_name_keyword!="":
            candidate_name=full_name_from_name_keyword
        elif full_name_from_first_line!="":
            candidate_name=full_name_from_first_line

        
    if candidate_name!="":
        print("candidate_name : "+candidate_name)
    else : print("Name cannot extracted...unsupported file format")
    
    return candidate_name


