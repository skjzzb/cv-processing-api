import experienceExtractionSimpleFormat
import experienceInFormat
def getExperience(filepath):
    
    experience=experienceExtractionSimpleFormat.experience(filepath)
    if experience!=0:
        noOfYear=experience
    else: noOfYear=experienceInFormat.experience(filepath)
    
    return noOfYear
