import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the email address to simulate phishing to: ");
        String recipient = scanner.nextLine();
        scanner.close();

        final String username = "7c00fd953ad970";     // Mailtrap SMTP username
        final String password = "139410a49e4732";     // Mailtrap SMTP password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("security@yourcompany.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Urgent: Resolve this right away! This is an internal requirement");

            message.setText(
                "Hello,\n\n" +
                "After completing an internal audit, we have recognized that your credentials do not meet the system’s minimum security requirements.\n\n" +
                "Please copy and paste the following link to update your credentials:\n" +
                "http://localhost:8080/fake-login.html\n\n" +
                "Thank you."
            );

            Transport.send(message);
            System.out.println("Phishing simulation sent successfully to: " + recipient);

            // Log the event
            ActivityTracker.logEmailSent(recipient);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
