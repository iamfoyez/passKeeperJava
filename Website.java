public class Website {

    private String name;
    private String link;
    private String username;
    private Email mail;
    private Password pass;

    public Website(String name, String link, String username, Email mail, Password pass) {
        this.name = name;
        this.link = link;
        this.username = username;
        this.mail = mail;
        this.pass = pass;
    }

    public String getDisplayText() {
        return this.name + " - " + this.username;
    }

    public void copyLink() {
        Copy.clipboardCopy(this.link);
    }

    public void copyUsername() {
        Copy.clipboardCopy(this.username);
    }

    public void copyMail() {
        this.mail.copyAddress();
    }

    public void copyPassword() {
        this.pass.copy();
    }

    @Override
    public String toString() {
        // format name, link, username, mailAddress, passId
        return this.name + "," + this.link + "," + this.username + "," + this.mail.getAddress() + ","
                + this.pass.getId();
    }

}
