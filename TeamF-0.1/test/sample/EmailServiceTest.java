package sample;
import static org.junit.Assert.*;


public class EmailServiceTest {

    //Uses a correct string of directions to send emails out
    String validDirections = ;

    //Send Email Tests

    //Steph - checks if email is not sent due to an invalid email recipient given
    @org.junit.Test
    public void sendNotValidEmail() throws Exception {
        EmailService notValid = new EmailService("teamFCS3733@gmail.com", "FuschiaFairiesSoftEng");
        //uses a non-valid email
        notValid.sendEmail(validDirections, "teamZCS3733@gmail.com");
        //if a vaild email is passed, the status should be set to the string below
        assertEquals("That is not a valid Email, try again!", notValid.status);
    }

    //Steph - checks if email was successfully sent with valid email
    @org.junit.Test
    public void sendSuccessfulEmail() throws Exception {
        EmailService successful = new EmailService("teamFCS3733@gmail.com", "FuschiaFairiesSoftEng");
        //if successful, the status should be "sent message"
        successful.sendEmail(validDirections, "teamFCS3733@gmail.com");
        assertEquals("Sent message", successful.status);
    }

    //Steph - checks if status was properly set for an error by using incorrect username
    @org.junit.Test
    public void sendErrorEmail() throws Exception {
        //uses incorrect email address
        EmailService error = new EmailService("teamZCS3733@gmail.com", "FuschiaFairiesSoftEng");
        error.sendEmail(validDirections, "");
        //if an error occurs, such as setting up the server, the status should be set to this
        assertEquals("An error occurred while sending the message", error.status);
    }

}
