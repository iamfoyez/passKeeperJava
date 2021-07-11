import java.util.LinkedList;
import java.util.Scanner;

public class ParseClass {

    public static Password password(String pass) {
        int id = Integer.parseInt(pass.split("~")[0]);
        String pw = pass.split("~")[1];
        return new Password(pw, id);
    }

    public static Email email(String mail, LinkedList<Password> passDir) {
        Scanner parseMail = new Scanner(mail);
        parseMail.useDelimiter(",");
        if (!parseMail.hasNextInt()) {
            parseMail.close();
            return null;
        }
        int i = parseMail.nextInt();
        int index = passDir.indexOf(new Password("L00kUp", i));
        if (index == -1) {
            System.out.println("Password Not Found");
            parseMail.close();
            return null;
        }
        Password pass = passDir.get(index);
        String provider = parseMail.next();
        String username = parseMail.next();
        String domain = parseMail.next();
        parseMail.close();
        return new Email(username, provider, domain, pass);
    }

    public static Website website(String web, LinkedList<Email> emails, LinkedList<Password> passwords) {
        Scanner parseWebsite = new Scanner(web);
        parseWebsite.useDelimiter(",");
        // name, link, username, mailAddress, passId
        String name = parseWebsite.next();
        String link = parseWebsite.next();
        String username = parseWebsite.next();
        String address = parseWebsite.next();
        // loop up password
        int i = parseWebsite.nextInt();
        parseWebsite.close();
        int index = passwords.indexOf(new Password("L00kUp", i));
        if (index == -1) {
            System.out.println("Password Not Found");
            return null;
        }
        Password pass = passwords.get(index);
        // look up email address
        int mailIndex = emails
                .indexOf(new Email(address.split("@")[0], "L00kUp", address.split("@")[1], new Password("L00kUp", 0)));
        if (mailIndex == -1) {
            System.out.println("No Such Email Found");
            return null;
        }
        Email mail = emails.get(mailIndex);
        return new Website(name, link, username, mail, pass);
    }

}
