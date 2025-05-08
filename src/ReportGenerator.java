
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    //Analyzes the log file and prints the phishing campaign summary
    public static void generateReport() {
        int emailsSent = 0;
        int emailsOpened = 0;
        int linksClicked = 0;
        int fakeLogins = 0;

        //Read the log file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader("activity_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Count each type of activity
                if (line.contains("EMAIL_SENT")) emailsSent++;
                else if (line.contains("EMAIL_OPENED")) emailsOpened++;
                else if (line.contains("LINK_CLICKED")) linksClicked++;
                else if (line.contains("FAKE_LOGIN")) fakeLogins++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print report to the console
        System.out.println("Phishing Campaign Report");
        System.out.println("Emails Sent: " + emailsSent);
        System.out.println("Emails Opened: " + emailsOpened);
        System.out.println("Links Clicked: " + linksClicked);
        System.out.println("Fake Logins Captured: " + fakeLogins);

        //Save report to a CSV file
        saveReportToCSV(emailsSent, emailsOpened, linksClicked, fakeLogins);
    }

    //Write the report to CSV file
    private static void saveReportToCSV(int emailsSent, int emailsOpened, int linksClicked, int fakeLogins) {
        try (FileWriter writer = new FileWriter("report.csv")) {
            writer.write("Metric,Count\n");
            writer.write("Emails Sent," + emailsSent + "\n");
            writer.write("Emails Opened," + emailsOpened + "\n");
            writer.write("Links Clicked," + linksClicked + "\n");
            writer.write("Fake Logins Captured," + fakeLogins + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
