package sample;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
        String userName;
        String passWord;

        public EmailService(String userName, String passWord) {
            this.userName = userName;
            this.passWord = passWord;
        }

        // Purpose: Sending an email through google's SMTP Server
        // Parameters: String Directions, String receiver (email address)
        public void sendEmail(String directions, String receiver) {
            // Email Server Properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            //server address
            props.put("mail.smtp.host", "smtp.gmail.com");
            //server ports
            props.put("mail.smtp.port", "587");

            // Logging in to the google server
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, passWord);
                }
            });

            try {
                // Composing the message
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("teamFCS3733@gmail.com")); // From
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // Target email addresses
                msg.setSubject("Testing");
                msg.setContent( directions,"text/html; charset=utf-8"); // Enter
                Transport.send(msg);
                System.out.println("Sent message");
            } catch (MessagingException e) {
                System.out.println("An error occurred while sending the message");
            }
        }
    }


