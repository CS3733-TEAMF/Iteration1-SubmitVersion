package sample;

import com.sun.mail.smtp.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.*;
import java.net.InetAddress;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailService {

    public EmailService(){

    }

    public void sendEmail() throws Exception{
        String  d_email = "address@gmail.com",
                d_uname = "Name",
                d_password = "urpassword",
                d_host = "smtp.gmail.com",
                d_port  = "465",
                m_to = "toAddress@gmail.com",
                m_subject = "Indoors Readable File: " + params[0].getName(),
                m_text = "This message is from Indoor Positioning App. Required file(s) are attached.";
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));

            Transport transport = session.getTransport("smtps");
            transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (AddressException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        /*
        //try {
            String userName = "florisvanrossum@gmail.com";
            String passwords = "BMWdonut1999";
            Properties props = System.getProperties(); // No idea
            props.put("mail.smtps.host", "smtp.gmail.com"); // Connecting to mail server
            props.put("mail.smtp.port", 587);
            props.put("mail.smtps.auth", "true");
            props.put("mail.smtp.startlls.enable", "true");
            props.put("mail.smtp.user", userName);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            char[] passWord = passwords.toCharArray();

            javax.mail.Authenticator auth = new javax.mail.Authenticator() {
                 public javax.mail.PasswordAuthentication getPasswordAuthentication(){
                     return new javax.mail.PasswordAuthentication(userName, passwords);
                }
            };
            Session session = Session.getInstance(props, auth);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("florisvanrossum@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("florisvanrossum@gmail.com",false));
            msg.setSubject("Testing");
            msg.setText("Directions will go here");
            msg.setHeader("Your map", "Directions of the hospital");
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", "florisvanrossum@gmail.com", "BMWdonut1999");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
            System.out.println("Sent");
        //} catch (Exception MessagingException){
            // Error handling here
            System.out.println("Error!");
        //}
        */
    }

}
