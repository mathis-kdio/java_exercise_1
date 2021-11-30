import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command {
    public String name() {
        return "freq";
    }
    public boolean run(Scanner scr) {
        System.out.println("Veuiller donner le chemin du fichier à analyser :");
        Path path = Paths.get(scr.nextLine());
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
        return true;
    }
}
