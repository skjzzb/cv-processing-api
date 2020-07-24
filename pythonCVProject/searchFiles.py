from datetime import datetime, timedelta
import datetime
utc_datetime = datetime.datetime.utcnow() - timedelta(hours = 24)
currentTime=utc_datetime.strftime('%Y-%m-%d')+"T"+utc_datetime.strftime('%H:%M:%S')
t_folder = "createdTime >"+"'"+currentTime+"'"
import searchCVandSendData

def searchFolder(service):
    results = service.files().list(
    pageSize=10, fields="nextPageToken, files(id, name)", q="name = 'CV'").execute()
    items = results.get('files', [])
    return items

def searchFolderByDate(service,nameOfFolder):
    results = service.files().list(
    pageSize=10, fields="nextPageToken, files(id, name)", q="name = '"+nameOfFolder+"'").execute()
    items = results.get('files', [])
    return items

def searchFile(folder_id,service):
    results = service.files().list(
    pageSize=10, fields="nextPageToken, files(id, name)", q=t_folder+" and mimeType='application/vnd.google-apps.folder' and  parents in '{}'".format(folder_id)).execute()
    items = results.get('files', [])

    if not items:
        print('No files found.')
    else:
        
        for item in items:
            searchCVandSendData.searchCVandSendData(item['id'],item['name'],service)