

def whichFieldsNotExtracted(candidate_data):
    fields=[]
    if candidate_data.get('candidateName')=="":
        fields.append('candidateName')
    if candidate_data.get('contactNo')=="":
        fields.append('contactNo')
    if candidate_data.get('technologyStack')=="":
        fields.append('technologyStack')
    return fields

