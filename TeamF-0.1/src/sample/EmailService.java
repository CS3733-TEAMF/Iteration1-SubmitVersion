package sample;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// Created by Stephanie and Floris
// Note: Antivirus and firewalls can cause problems with sending emails
// Purpose: Send directions to a user defined email
public class EmailService {
        String userName;
        String passWord;
        //Testing component, has a testable message to be used in junit
        String status;

        public EmailService(String userName, String passWord) {
            this.userName = userName;
            this.passWord = passWord;
        }

        // Purpose: Sending an email through google's SMTP Server
        // Parameters: String Directions, String receiver (email address)
        public void sendEmail(String directions, String receiver) throws InvalidEmailException {
            // Check to see if a valid email address was entered
            if(receiver.length() < 4 || !(receiver.contains("@"))) {
                // Work on the invalid email exception here
                this.status = "That is not a valid Email, try again!";
                System.out.println(this.status);
                throw new InvalidEmailException(receiver);
            } else {
                // Email server properties
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                //server address
                props.put("mail.smtp.host", "smtp.gmail.com");
                //server ports
                props.put("mail.smtp.port", "587");
                props.put("javax.net.ssl.trustStore", "C:/.keystore");

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
                    msg.setSubject("Your Directions for Brigham & Women's Hospital");
                    msg.setContent(directions, "text/html; charset=utf-8"); // Enter
                    Transport.send(msg);
                    this.status = "Sent message";
                    System.out.println(this.status);
                } catch (MessagingException e) {
                    this.status = "An error occurred while sending the message";
                    System.out.println(this.status);
                }
            }
        }
    }


