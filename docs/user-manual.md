User Manual: Phishing Campaign Simulation Tool

Overview
This tool simulates a phishing attack by generating a fake email using Java. It does **not send** any real email — the purpose is to raise awareness of phishing tactics.

Key Requirements
Version of Java 17+ or newer
javax.mail-1.6.2.jar
activation-1.1.1.jar

## ▶️ How to Run
1. Navigate to your project folder in Git Bash
2. Compile the code:
bash
javac -cp "javax.mail-1.6.2.jar;activation-1.1.1.jar" src/EmailSender.java
java -cp "src;javax.mail-1.6.2.jar;activation-1.1.1.jar" EmailSender

The Expected Output 
A fake phishing message will be printed to the console. This includes a subject, recipient, and a fake HTML message.

