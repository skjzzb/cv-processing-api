import emailAndContact
import tech_stack
import Name_entity_extraction
import send_candidate_data_JSON
import fileStructure
import updatedVacancy

vacancies=updatedVacancy.getVacancies()
if len(vacancies.json())!=0:
      files=fileStructure.file_structure()
      print(files)
      for item in files:
            send_candidate_data_JSON.send(item['name'])
      

 









