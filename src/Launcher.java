import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        boolean quit = false;
        List<Command> listeCommandes = new LinkedList<>();
        listeCommandes.add(new Quit());
        listeCommandes.add(new Fibo());
        listeCommandes.add(new Freq());
        do {
            System.out.println("Veuiller donner une commande : ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            boolean commandeConnue = false;
            for (int i = 0; i < listeCommandes.size(); i++) {
                if (str.equals(listeCommandes.get(i).name())) {
                    quit = listeCommandes.get(i).run(sc);
                    commandeConnue = true;
                    break;
                }
            }
            if (commandeConnue == false) {
                System.out.println("Unknown command");
            }
        } while (!quit);
    }
}
