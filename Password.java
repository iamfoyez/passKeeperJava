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

    @Override
    public String toString() {
        return this.id + "~" + this.pass;
    }

}