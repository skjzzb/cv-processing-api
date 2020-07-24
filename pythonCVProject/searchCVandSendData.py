import requests
headers={'Content-type':'application/json', 'Accept':'application/json'}

yesterdays_folder_name=""
def searchCVandSendData(folder_id,folder_name, service):
    results = service.files().list(
                pageSize=10, fields="nextPageToken, files(id, name)", q="mimeType='application/pdf' and parents in '{}'".format(folder_id)).execute()
    items = results.get('files', [])
    noOfCv=len(items)
    global yesterdays_folder_name
    doc_data={
        'folderName':folder_name,
        'noCV':noOfCv
    }
    print(doc_data)
    if folder_name!=yesterdays_folder_name:
        yesterdays_folder_name=folder_name
        url = 'https://cv-processing-api.herokuapp.com/v1/doc'
        x = requests.post(url, json=doc_data,headers=headers)
        
    elif folder_name==yesterdays_folder_name:
        url = 'https://cv-processing-api.herokuapp.com/v1/doc/update'
        x = requests.put(url, json=doc_data,headers=headers)
        
