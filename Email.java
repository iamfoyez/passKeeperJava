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
    public boolean equals(Object obj) {
        if (!(obj instanceof Email))
            return false;
        Email m1 = (Email) obj;
        if (m1.getAddress().equals(this.getAddress()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        // format-> passId, provider, username, domain
        // 1,Google,aflextra,gmail.com
        return this.pass.getId() + "," + this.provider + "," + this.username + "," + this.domain;
    }

}
