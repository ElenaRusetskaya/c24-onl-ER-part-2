package by.teachmeskills.lesson36.hw1;

import java.util.HashMap;
import java.util.Map;

/**
 * Задача 1:
 * На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
 * строка является ключом, и ее значение равно true, если эта строка встречается в массиве
 * 2 или более раз.
 * Пример:
 * wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
 * wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
 */
public class WordMultiple {
    public static void main(String[] args) {
        System.out.println(wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(wordMultiple(new String[]{"c", "c", "c", "c"}));
    }
    public static Map<String, Boolean> wordMultiple(String[] variables) {
        Map<String, Boolean> result = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : variables)
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word : variables)
            result.put(word, count.get(word) >= 2);
        return result;
    }
}