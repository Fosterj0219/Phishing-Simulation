import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {

        final String username = "Testing123_email@gmail.com"; // 
        final String password = "Testing_password";         // Use an app password or test password

        // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Start a mail session with authentication
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("ApprovedTesting@example.com") // ✅ Replace with recipient
            );
            message.setSubject("Very Important: Take Immediate Action");
            message.setContent(
                "<h3>This is a simulated phishing email.</h3><p>Please click below to verify:</p>" +
                "<a href='http://localhost:8080/fake-login'>Click here</a>",
                "text/html"
            );

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
