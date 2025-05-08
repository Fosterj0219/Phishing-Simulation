import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
	System.out.println("I AM INSIDE THE MAIN");
        final String username = "testinglaptoplaptop@gmail.com";

        try {
            // Simulated session — no real SMTP, no authentication
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props);

            // Build the fake email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("recipient@example.com")
            );
            message.setSubject("⚠ Urgent: Account Verification Required");
            message.setContent(
                "<h3>This is a simulated phishing email.</h3>" +
                "<p>Please click below to verify your account:</p>" +
                "<a href='http://localhost:8080/fake-login'>Click here</a>",
                "text/html"
            );

            // Simulate sending output (no real send)
            System.out.println("✅ THIS IS MY FINAL SIMULATED EMAIL VERSION");
            System.out.println("To: " + message.getAllRecipients()[0]);
            System.out.println("Subject: " + message.getSubject());
            System.out.println("Body:\n" + message.getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

