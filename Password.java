public class Password {

    private String pass;

    public Password(String pass) {
        this.pass = pass;
    }

    public void copy() {
        Copy.clipboardCopy(this.pass);
    }

    @Override
    public String toString() {
        return this.pass;
    }

}