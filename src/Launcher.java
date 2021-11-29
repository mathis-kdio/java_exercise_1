import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        boolean isEquals = false;
        do {
            Scanner sc = new Scanner(System.in);
            String i = sc.nextLine();
            isEquals = i.equals("quit");
            if (!isEquals) {
                System.out.println("Unknown command");
            }
        } while (!isEquals);
    }
}
