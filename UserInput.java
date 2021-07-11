import java.util.Scanner;

public class UserInput {

    public static Scanner io = new Scanner(System.in);

    public static int getInt(String msg) {
        System.out.print(msg + ": ");
        String line = UserInput.io.nextLine();
        Scanner parseLine = new Scanner(line);
        if (parseLine.hasNextInt()) {
            int n = parseLine.nextInt();
            parseLine.close();
            return n;
        }
        parseLine.close();
        return UserInput.getInt(msg);
    }

    public static String getStr(String msg) {
        System.out.print(msg + ": ");
        String line = UserInput.io.nextLine();
        if (line.strip().equals(""))
            return UserInput.getStr(msg);
        return line.strip();
    }

}
