
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.*;

public class SendEmail {
    public static void main(String [] args) throws EmailException, MalformedURLException{
        
        //  Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif"));
        attachment.setPath("D:/azbW3zq_460sa_v1.gif");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("This is some gif file!");
        attachment.setName("GIF-che");

        // Create the email message
       MultiPartEmail emails = new MultiPartEmail();
      //  emails.setHostName(" https://mail.google.com");
        emails.setHostName("smtp.googlemail.com");
        emails.setSmtpPort(465);
        emails.setSSLOnConnect(true);
        emails.setAuthentication("desita.dincheva@gmail.com", "*****");
        emails.addTo("desi_dincheva@abv.bg", "Desi");
        emails.setFrom("desita.dincheva@gmail.com", "Me");
        emails.setSubject("The gif");
        emails.setMsg("This is my first message send with the help of java!");

        // add the attachment
        emails.attach(attachment);

        // send the email
        emails.send();
    }

}
