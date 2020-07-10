import datetime

x = datetime.datetime.now()

print(x.strftime("%X"))
print(x.strftime("%H-%M"))
print(x.strftime("%Y-%m-%d"))

def create(service,folders):
    for folder in folders:
        if folder['name']=='CV':
            folder_id=folder['id']
    
    if (x.strftime("%H"))=='15':
        print("folder created")
        file_metadata = {
            'name': (x.strftime("%d-%m-%Y")),
            'mimeType': 'application/vnd.google-apps.folder',
            'parents': [folder_id]
        }
        file = service.files().create(body=file_metadata,
                                         fields='id').execute()
        print ('Folder ID: %s' % file.get('id'))














       
