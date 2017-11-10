package sample;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService {

    public static void main(String[] args){

        //way to send email through app
        final String username = "teamF@gmail.com";
        final String password = "password";

        //enables, and sets up properties of server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //server address
        props.put("mail.smtp.host", "smtp.gmail.com");
        //server port
        props.put("mail.smtp.port", "587");

        //logs in
        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //authorization
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("stephanie.r.racca@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("srracca@wpi.edu"));
            msg.setSubject("Email System Working");
            msg.setContent("Here is where the directions would go", "text/html; charset=utf-8");
            Transport.send(msg);

            System.out.println("The message sent!");

        } catch (MessagingException e){
            System.out.println("Error!");
        }
    }
}

