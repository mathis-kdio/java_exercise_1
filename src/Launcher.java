import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        if (i.equals("quit") == false) {
            System.out.println("Unknown command");
        }
    }
}
