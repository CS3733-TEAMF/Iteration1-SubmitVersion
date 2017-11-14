package sample;


//import com.sun.mail.smtp  MTPMessage;

import com.sun.mail.smtp.SMTPMessage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

// Created by Stephanie and Floris
// Note: Antivirus and firewalls can cause problems with sending emails
// Purpose: Send directions to a user defined email
public class EmailService implements Data {
    String userName;
    String passWord;
    //Testing component, has a testable message to be used in junit
    String status;

    public EmailService(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.status = "Setting up email services...";
    }

    private static String formatEmail(String directions) {
        String email = "<!DOCTYPE html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <!--[if !mso]><!-- -->\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <!--<![endif]-->\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <style type=\"text/css\">\n" +
                "        #outlook a {\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        \n" +
                "        .ReadMsgBody {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        \n" +
                "        .ExternalClass {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        \n" +
                "        .ExternalClass * {\n" +
                "            line-height: 100%;\n" +
                "        }\n" +
                "        \n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            -webkit-text-size-adjust: 100%;\n" +
                "            -ms-text-size-adjust: 100%;\n" +
                "        }\n" +
                "        \n" +
                "        table,\n" +
                "        td {\n" +
                "            border-collapse: collapse;\n" +
                "            mso-table-lspace: 0pt;\n" +
                "            mso-table-rspace: 0pt;\n" +
                "        }\n" +
                "        \n" +
                "        img {\n" +
                "            border: 0;\n" +
                "            height: auto;\n" +
                "            line-height: 100%;\n" +
                "            outline: none;\n" +
                "            text-decoration: none;\n" +
                "            -ms-interpolation-mode: bicubic;\n" +
                "        }\n" +
                "        \n" +
                "        p {\n" +
                "            display: block;\n" +
                "            margin: 13px 0;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <!--[if !mso]><!-->\n" +
                "    <style type=\"text/css\">\n" +
                "        @media only screen and (max-width:480px) {\n" +
                "            @-ms-viewport {\n" +
                "                width: 320px;\n" +
                "            }\n" +
                "            @viewport {\n" +
                "                width: 320px;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "    <!--<![endif]-->\n" +
                "    <!--[if mso]><xml>  <o:OfficeDocumentSettings>    <o:AllowPNG/>    <o:PixelsPerInch>96</o:PixelsPerInch>  </o:OfficeDocumentSettings></xml><![endif]-->\n" +
                "    <!--[if lte mso 11]><style type=\"text/css\">  .outlook-group-fix {    width:100% !important;  }</style><![endif]-->\n" +
                "    <style type=\"text/css\">\n" +
                "        @media only screen and (min-width:480px) {\n" +
                "            .mj-column-per-100 {\n" +
                "                width: 100%!important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"background: #FFFFFF;\">\n" +
                "    <div class=\"mj-container\" style=\"background-color:#FFFFFF;\">\n" +
                "        <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]-->\n" +
                "        <div style=\"margin:0px auto;max-width:600px;\">\n" +
                "            <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" align=\"center\" border=\"0\">\n" +
                "                <tbody>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:9px 0px 9px 0px;\">\n" +
                "                            <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]-->\n" +
                "                            <div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\">\n" +
                "                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                    <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"word-wrap:break-word;font-size:0px;padding:0px 0px 0px 0px;\" align=\"center\">\n" +
                "                                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\">\n" +
                "                                                    <tbody>\n" +
                "                                                        <tr>\n" +
                "                                                            <td style=\"width:180px;\"><img alt=\"\" title=\"\" height=\"auto\" src=\"https://topolio.s3-eu-west-1.amazonaws.com/uploads/5a088766bdb4e/1510510340.jpg\" style=\"border:none;border-radius:0px;display:block;font-size:13px;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"180\"></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </tbody>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </div>\n" +
                "                            <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "        <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "        <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]-->\n" +
                "        <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"background:#0161B2;font-size:0px;width:100%;\" border=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <div style=\"margin:0px auto;max-width:600px;\">\n" +
                "                            <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" align=\"center\" border=\"0\">\n" +
                "                                <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:9px 0px 9px 0px;\">\n" +
                "                                            <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]-->\n" +
                "                                            <div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\">\n" +
                "                                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                                    <tbody>\n" +
                "                                                        <tr>\n" +
                "                                                            <td style=\"word-wrap:break-word;font-size:0px;padding:0px 20px 0px 20px;\" align=\"center\">\n" +
                "                                                                <div style=\"cursor:auto;color:#000000;font-family:Georgia, sans-serif;font-size:11px;line-height:22px;text-align:center;\">\n" +
                "                                                                    <p><span style=\"color:#ffffff;\"><span style=\"font-size:22px;\">Your Directions for the Brigham &amp; Women&apos;s Hospital</span></span>\n" +
                "                                                                    </p>\n" +
                "                                                                </div>\n" +
                "                                                            </td>\n" +
                "                                                        </tr>\n" +
                "                                                    </tbody>\n" +
                "                                                </table>\n" +
                "                                            </div>\n" +
                "                                            <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </tbody>\n" +
                "                            </table>\n" +
                "                        </div>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "        <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]-->\n" +
                "        <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"background:#0161B2;font-size:0px;width:100%;\" border=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <div style=\"margin:0px auto;max-width:600px;\">\n" +
                "                            <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" align=\"center\" border=\"0\">\n" +
                "                                <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:9px 0px 9px 0px;\">\n" +
                "                                            <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]-->\n" +
                "                                            <div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\">\n" +
                "                                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                                    <tbody>\n" +
                "                                                        <tr>\n" +
                "                                                            <td style=\"word-wrap:break-word;font-size:0px;padding:100px 20px 100px 20px;\" align=\"left\">\n" +
                "                                                                <div style=\"cursor:auto;color:#000000;font-family:Georgia, sans-serif;font-size:11px;line-height:22px;text-align:left;\">\n" +
                "                                                                    <p><span style=\"font-size:14px;\"><span style=\"color:#ffffff;\">Directions:<br> " + directions + "</span></span>\n" +
                "                                                                        <br>&#xA0;</p>\n" +
                "                                                                </div>\n" +
                "                                                            </td>\n" +
                "                                                        </tr>\n" +
                "                                                    </tbody>\n" +
                "                                                </table>\n" +
                "                                            </div>\n" +
                "                                            <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </tbody>\n" +
                "                            </table>\n" +
                "                        </div>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "        <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]-->\n" +
                "        <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" border=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <div style=\"margin:0px auto;max-width:600px;\">\n" +
                "                            <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" align=\"center\" border=\"0\">\n" +
                "                                <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:9px 0px 9px 0px;\">\n" +
                "                                            <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]-->\n" +
                "                                            <div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\">\n" +
                "                                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                                    <tbody>\n" +
                "                                                        <tr>\n" +
                "                                                            <td style=\"word-wrap:break-word;font-size:0px;padding:0px 0px 0px 0px;\" align=\"center\">\n" +
                "                                                                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\">\n" +
                "                                                                    <tbody>\n" +
                "                                                                        <tr>\n" +
                "                                                                            <td style=\"width:144px;\"><img alt=\"\" title=\"\" height=\"auto\" src=\"cid:image\" style=\"border:none;border-radius:0px;display:block;font-size:13px;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"144\"></td>\n" +
                "                                                                        </tr>\n" +
                "                                                                    </tbody>\n" +
                "                                                                </table>\n" +
                "                                                            </td>\n" +
                "                                                        </tr>\n" +
                "                                                    </tbody>\n" +
                "                                                </table>\n" +
                "                                            </div>\n" +
                "                                            <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </tbody>\n" +
                "                            </table>\n" +
                "                        </div>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <!--[if mso | IE]>      </td></tr></table>      <![endif]-->\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        return email;
    }

    // Purpose: Sending an email through google's SMTP Server
    // Parameters: String Directions, String receiver (email address)
    public void sendEmail(String directions, String receiver) throws InvalidEmailException, IOException {
        System.out.println(status);
        // Check to see if a valid email address was entered
        if (receiver.length() < 4 || !(receiver.contains("@"))) {
            // Work on the invalid email exception here
            this.status = "That is not a valid Email, try again!";
            System.out.println(this.status);
            throw new InvalidEmailException(receiver);
        } else {

            try {
                Session session = buildSession(userName,passWord);
                Message msg = buildMessage(session,directions,receiver);
                Transport.send(msg);
                this.status = "Sent message";
                System.out.println(this.status);
            } catch (MessagingException e) {
                this.status = "An error occurred while sending the message";
                System.out.println(this.status);
            }
        }
    }

    private static Message buildMessage(javax.mail.Session session, String directions, String receiver) throws MessagingException, IOException {
        // Composing the message
        SMTPMessage msg = new SMTPMessage(session);
        MimeMultipart content = new MimeMultipart();
        MimeBodyPart mainBody = new MimeBodyPart();
        MimeBodyPart image = new MimeBodyPart();
        MimeBodyPart fileAttach = new MimeBodyPart();

        mainBody.setContent(formatEmail(directions), "text/html; charset=utf-8"); // Enter

        String filePath = Data.data.currentMap;
        DataSource mapFile = new FileDataSource(filePath);
        image.setDataHandler(new DataHandler(mapFile));
        image.setHeader("Content-ID", "<image>");

        fileAttach.setDataHandler(new DataHandler(mapFile));
        fileAttach.setFileName(new File(filePath).getName());

        content.addBodyPart(mainBody);
        content.addBodyPart(image);
        content.addBodyPart(fileAttach);
        msg.setContent(content);
        msg.setFrom(new InternetAddress("teamFCS3733@gmail.com")); // From
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // Target email addresses
        msg.setSubject("Your Directions for Brigham & Women's Hospital");
        return  msg;
    }

    public static Session buildSession(String userName, String passWord) {
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
        return session;
    }

}