package lab6_Collections;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class FreqCounter {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //List<String> words = new ArrayList<>(Arrays.asList(args));
        printFreqByWords(words);

        List<Character> characters = new ArrayList<>();
        for (String s : args) {
            char[] arg = s.toLowerCase().toCharArray();
            for (int j = 0; j < s.length(); j++) {
                characters.add(arg[j]);
            }
        }
        printFreqByLiteral(characters);
    }

    static void printFreqByLiteral(List<Character> characters) {
        Map<Character, Long> res = characters.stream().
                collect(Collectors.groupingBy(e -> e,  Collectors.counting()));
        res.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.print(e.getValue() + " - " + e.getKey() + "; "));
    }

    static void printFreqByWords(List<String> words) {
        Map<String, Long> res = words.stream().
                collect(Collectors.groupingBy(String::toLowerCase,  Collectors.counting()));
        res.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.print(e.getValue() + " - " + e.getKey() + "; "));
    }
}
