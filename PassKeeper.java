import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class PassKeeper {

    private LinkedList<Password> passwords;
    private LinkedList<Email> emails;
    private LinkedList<Website> websites;
    private String fileName;

    public PassKeeper(String fileName) {
        this.passwords = new LinkedList<Password>();
        this.emails = new LinkedList<Email>();
        this.websites = new LinkedList<Website>();
        this.fileName = fileName;
        this.readFile();
    }

    private void readFile() {
        try {
            File passFile = new File(this.fileName);
            Scanner parser = new Scanner(passFile);
            int mode = 0;
            while (parser.hasNextLine()) {
                String line = parser.nextLine();
                if (line.strip().startsWith("~~")) {
                    mode++;
                } else {
                    if (mode == 1) {
                        // passwords
                        Password pw = ParseClass.password(line);
                        if (pw != null)
                            this.passwords.add(pw);
                    } else if (mode == 2) {
                        // emails
                        Email em = ParseClass.email(line, this.passwords);
                        if (em != null)
                            this.emails.add(em);
                    } else if (mode == 3) {
                        // websites
                        Website web = ParseClass.website(line, this.emails, this.passwords);
                        if (web != null)
                            this.websites.add(web);
                    }
                }
            }
            parser.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File Found!");
            e.printStackTrace();
        }
    }

    private boolean writeData() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            writer.write(this.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "~~Passwords\n";
        // Loop through all passwords
        for (int i = 0; i < this.passwords.size(); i++) {
            str += this.passwords.get(i).toString() + "\n";
        }
        str += "~~Emails\n";
        // Loop through all Emails.
        for (int i = 0; i < this.emails.size(); i++) {
            str += this.emails.get(i).toString() + "\n";
        }
        str += "~~Websites\n";
        // Loop through all websites.
        for (int i = 0; i < this.websites.size(); i++) {
            str += this.websites.get(i).toString() + "\n";
        }
        return str.strip();
    }

    public static void main(String[] args) {
        var pk = new PassKeeper("D:\\Projects\\passKeeperJava\\database.pass");
        System.out.println(pk);
    }

}
