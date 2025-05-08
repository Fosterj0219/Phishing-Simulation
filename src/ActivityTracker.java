import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ActivityTracker {
    private static final String LOG_FILE = "activity_log.txt";
    
    //Logs when an email is sent
    public static void logEmailSent(String emailId) {
        log("EMAIL_SENT", emailId);
    }

    //Logs when a user opens the email
    public static void logEmailOpened(String emailId) {
        log("EMAIL_OPENED", emailId);
    }

    //Logs when a user clicks the phishing link
    public static void logLinkClicked(String emailId) {
        log("LINK_CLICKED", emailId);
    }

    //Logs when a user enters fake login credentials
    public static void logFakeLoginCaptured(String emailId) {
        log("FAKE_LOGIN", emailId);
    }

    //Write a log entry with time, action, and email
    private static void log(String action, String emailId) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String logEntry = LocalDateTime.now() + "," + action + "," + emailId + "\n";
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
