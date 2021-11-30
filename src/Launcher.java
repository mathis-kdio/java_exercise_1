import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        boolean isEquals = false;
        do {
            System.out.println("Veuiller donner une commande : ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("fibo")) {
                System.out.println("Nombre n de la suite de fibo :");
                Scanner scFibo = new Scanner(System.in);
                int n = Integer.parseInt(scFibo.nextLine());
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
            }
            else if (str.equals("freq")) {
                System.out.println("Veuiller donner le chemin du fichier à analyser :");
                Scanner scFreq = new Scanner(System.in);
                Path path = Paths.get(scFreq.nextLine());
                try {
                    String words = java.nio.file.Files.readString(path);
                    String[] wordsArray = words.toLowerCase().split(" ");
                    Map<String, Long> res = Arrays.stream(wordsArray)
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                    LinkedHashMap<String, Long> resTrie = new LinkedHashMap<>();
                    res.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3).forEachOrdered(x -> resTrie.put(x.getKey(), x.getValue()));
                    for (Map.Entry<String, Long> pair : resTrie.entrySet()) {
                        System.out.print(String.format("%s ", pair.getKey()));
                    }
                }
                catch (IOException e) {
                    System.out.println("Unreadable file: ");
                    e.printStackTrace();
                }
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
