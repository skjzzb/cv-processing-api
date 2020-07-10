import emailAndContact
import tech_stack
import Name_entity_extraction
import send_candidate_data_JSON
import fileStructure
import updatedVacancy

vacancies=updatedVacancy.getVacancies()
if len(vacancies.json())!=0:
      items=fileStructure.file_structure()
      print(items)
      for item in items:
            send_candidate_data_JSON.send(item['name'])
      

 









