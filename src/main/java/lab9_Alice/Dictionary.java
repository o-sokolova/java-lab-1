package lab9_Alice;

import java.util.*;

public class Dictionary {
    private static final Map<String, Integer> dictionary = new HashMap<>();

    static {
        dictionary.put("погода", 20);
        dictionary.put("друг", 25);
        dictionary.put("компьютер", 30);
        dictionary.put("что", 5);
        dictionary.put("Алиса", 7);
        dictionary.put("магазин", 10);
        dictionary.put("книга", 15);
        dictionary.put("сколько", 20);
        dictionary.put("имя", 30);
    }

    public static Integer getWordWeight (String word) {
        return dictionary.get(word);
    }

    public static String getWordWithMAxWeight(String[] userWords) {
        Map<String, Integer> wordsInDict = new HashMap<>();
        Integer prio;
        for (String word: userWords) {
            if ((prio = getWordWeight(word)) != null ){
                wordsInDict.put(word, prio);
            }
        }
        System.out.println(wordsInDict.toString());
        return (wordsInDict.size() == 0) ? userWords[(int) Math.floor((Math.random() * userWords.length))] :
                Collections.max(wordsInDict.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
