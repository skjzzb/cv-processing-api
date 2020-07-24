import smtplib


def sendMail(recivermailaddress,fields):
    # creates SMTP session 
    s = smtplib.SMTP('smtp.gmail.com', 587) 
    
    # start TLS for security 
    s.starttls() 
    
    # Authentication 
    s.login("demomailspringboot123@gmail.com", "Spring@2020") 
    
    # message to be sent 
    subject="Update your details for GSlab job"
    salutation="Hi,"
    body="We are from GSlab. We are not able to extract your information from your resume so please go to the below url and fill your details."
    link="link: https://google.com"
    signature="Regards,"
    name="GSlab team"
    msg=f'Subject: {subject}\n\n{salutation}\n{body}\n{link}\n\n{signature}\n{name}'
    # sending the mail 
    s.sendmail("demomailspringboot123@gmail.com", recivermailaddress, msg) 
    
    # terminating the session 
    s.quit() 
#sendMail("akhawatsahdev@gmail.com",5)