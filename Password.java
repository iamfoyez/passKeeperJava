public class Password {

    private String pass;
    private int id;

    public Password(String pass, int id) {
        this.pass = pass;
        this.id = id;
    }

    public String getPassword() {
        return this.pass;
    }

    public int getId() {
        return this.id;
    }

    public void copy() {
        Copy.clipboardCopy(this.pass);
    }

    public String getDisplayText() {
        return this.id + " " + this.pass;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Password))
            return false;
        Password p1 = (Password) obj;
        if (p1.id == this.id)
            return true;
        if (p1.pass.equals(this.pass))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.id + "~" + this.pass;
    }

}