public class Email {

    private String username;
    private String provider;
    private String domain;
    private Password pass;

    public Email(String username, String provider, String domain, Password pass) {
        this.username = username;
        this.provider = provider;
        this.domain = domain;
        this.pass = pass;
    }

    public String getAddress() {
        return this.username + "@" + this.domain;
    }

    public void copyAddress() {
        Copy.clipboardCopy(this.getAddress());
    }

    public void copyPassword() {
        this.pass.copy();
    }

    public String getDisplayText() {
        return this.provider + " - " + this.getAddress();
    }

    @Override
    public String toString() {
        // format-> provider, username, domain, passId
        return this.provider + "," + this.username + "," + this.domain + "," + this.pass.getId();
    }

}
