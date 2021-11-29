import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        boolean isEquals = false;
        do {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("fibo")) {
                System.out.println("Nombre n de la suite de fibo :");
                Scanner scFibo = new Scanner(System.in);
                int n = Integer.parseInt(scFibo.nextLine());
                int f0 = 0, f1 = 1, fn = 0;
                for (int i = 1; i < n; i++) {
                    fn = f1 + f0;
                    f0 = f1;
                    f1 = fn;
                    System.out.println(fn);
                }
                System.out.println("A l'index f(" + n + "), la valeur de la suite de Fibonacci est " + fn);
            }
            else {
                isEquals = str.equals("quit");
                if (!isEquals) {
                    System.out.println("Unknown command");
                }
            }
        } while (!isEquals);
    }
}
