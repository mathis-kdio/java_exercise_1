import java.util.Scanner;

public class Fibo implements Command {
    public String name() {
        return "fibo";
    }
    public boolean run(Scanner scr) {
        System.out.println("Nombre n de la suite de fibo :");
        int n = Integer.parseInt(scr.nextLine());
        int f0 = 0, f1 = 1, fn = 1;
        if (n == 0) {
            fn = 0;
        }
        for (int i = 1; i < n; i++) {
            fn = f1 + f0;
            f0 = f1;
            f1 = fn;
            System.out.println(fn);
        }
        System.out.println("A l'index f(" + n + "), la valeur de la suite de Fibonacci est " + fn);
        return true;
    }
}
