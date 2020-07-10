
import pickle
import PyPDF2
import random
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

 ###############
def Name_from_trained_model(nlp_model,text_file):
    # nlp_model=spacy.load('../nlp_model') 
    # text_file=open('../demo.txt','r')
    text=text_file.read()
    text1=text.replace('Name:','')
    text1=text1.replace('-','')
    text1=text1.replace('Name','')
    text1=text1.replace('VITAE','')
    text1=text1.replace('Vitae','')
    text1=text1.replace('CURRICULUM','')
    text1=text1.replace('Curriculum','')
    text1=text1.replace('Resume','')
    text1=text1.replace('RESUME','')
    text1=text1.replace(':','')
    tx=" ".join(text1.split('\n'))

    doc=nlp_model(tx)
    # print(f'{doc.ents[0].label_.upper():{30}}-{doc.ents[0].text}')
    Name_from_trained_model=""
    Name_from_trained_model=doc.ents[0].text
    return (Name_from_trained_model)


# Name_from_trained_model()