
import io
import PyPDF2
from googleapiclient.http import MediaIoBaseDownload
import searchFiles
from apiclient import errors
from apiclient import http





def downloadRecentCV(service):
    from datetime import datetime, timedelta
    import datetime
    utc_datetime = datetime.datetime.utcnow() - timedelta(hours = 1)
    currentTime=utc_datetime.strftime('%Y-%m-%d')+"T"+utc_datetime.strftime('%H:%M:%S')

    today=datetime.datetime.now()
    date=today.strftime('%d')+"-"+today.strftime('%m')+"-"+today.strftime('%Y')
    
    folders=searchFiles.searchFolderByDate(service,date)
    folder=folders[0]
    folder_id=folder['id']
    

    t = "createdTime >"+"'"+currentTime+"'"+" and mimeType='application/pdf'"
    print(t)    
    
    results = service.files().list(
        q=t+" and  parents in '{}'".format(folder_id),
        pageSize=100, fields="nextPageToken, files(id, name)").execute()
    items = results.get('files', [])

    if not items:
        print('No files found.')
    else:
        print('Files:')
        for item in items:
            print(u'{0} ({1})'.format(item['name'], item['id']))
            print_file_metadata(service, item['id'])

                    

            download_file(service, item['id'],item['name'])    

    return items  
    
def print_file_metadata(service, file_id):
    try:
        file = service.files().get(fileId=file_id).execute()

        print( 'Title: %s' % file['name'])
        print ('MIME type: %s' % file['mimeType'])
    except errors.HttpError as error:
        print( 'An error occurred: %s' % error)



def print_file_content(service, file_id):
    try:
        print ((service.files().get_media(fileId=file_id).execute() ))
    except errors.HttpError as  error:
        print ( 'An error occurred: %s' % error)

def download_file(service, file_id, file_name):
     request = service.files().get_media(fileId=file_id)
     local_fd  = io.FileIO(file_name, 'wb')
     media_request = http.MediaIoBaseDownload(local_fd, request)
     while True:
        try:
            download_progress, done = media_request.next_chunk()
        except errors.HttpError as error:
             print( 'An error occurred: %s' % error)
             return
        if download_progress:
             print ('Download Progress: %d%%' % int(download_progress.progress() * 100))
        if done:
             print ('Download Complete')
             return

