import requests
import tech_stack
import Read_from_pdf
import updatedVacancy

def skillMatching(technologyStack,JD):
    jobDescription=JD.split(',')
    matchedTechnology=0
    for jd in jobDescription:
        if any(jd in tech for tech in technologyStack):
            matchedTechnology+=1
    
    if len(jobDescription)!=0:
        matchingPercentage=(matchedTechnology/len(jobDescription))*100
    else:matchingPercentage=0
    return matchingPercentage


def combinedPercent(tech_stack_percent,short_summary_percent):
    combinedPercentage=(tech_stack_percent+short_summary_percent)/2
    return combinedPercentage




