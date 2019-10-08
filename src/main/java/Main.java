import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("src/main/resources/words.txt"));
            List words = new ArrayList<>();

            while (in.hasNext()) {
                words.addAll(Arrays.asList(in.nextLine().replaceAll("\\p{P}","").toLowerCase().split(" ")));
            }
            Arrays.stream(words.toArray()).collect(groupingBy(x -> x, counting()))
                    .forEach((word,count) -> System.out.println(String.format("%s: %d",word,count)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}