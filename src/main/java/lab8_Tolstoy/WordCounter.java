package lab8_Tolstoy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("vim1.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split("\\s+|\\p{Punct}+")));
            }
            BufferedWriter bufferedWriter = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream("result.txt")));
            countWords(words, bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void countWords(List<String> words, Writer bufferedWriter) {
        Map<String, Long> res = words.stream()
                .filter(e -> e.length() >= 3)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        res.entrySet().stream()
                .filter(e -> e.getValue() >= 100)
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e.getValue() + " - " + e.getKey() + "; \n");
                        bufferedWriter.flush();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
    }
}
