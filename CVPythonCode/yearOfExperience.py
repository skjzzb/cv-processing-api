import experienceExtractionSimpleFormat
import experienceInFormat
def getExperience(filepath):
    
    experience=experienceExtractionSimpleFormat.experience(filepath)
    if len(experience)!=0:
        noOfYear=experience[0]
    else: noOfYear=experienceInFormat.experience(filepath)
    
    return noOfYear
