package by.teachmeskills.lesson36.hw2;

import java.util.HashMap;
import java.util.Map;

/**
 * Задача 2:
 * На вход поступает массив непустых строк, создайте и верните Map<String,
 * String> следующим образом: для каждой строки добавьте ее первый символ в
 * качестве ключа с последним символом в качестве значения.
 * Пример:
 * pairs(["code", "bug"]) → {"b": "g", "c": "e"}
 * pairs(["man", "moon", "main"]) → {"m": "n"}
 * pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(pairs(new String[]{"code", "bug"}));
        System.out.println(pairs(new String[]{"man", "moon", "main"}));
        System.out.println(pairs(new String[]{"man", "moon", "good", "night"}));
    }
    public static String pairs(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String string : strings) {
            if (!string.isEmpty()) {
                char charFirst = string.charAt(0);
                char charLast = string.charAt(string.length() - 1);
                result.put(String.valueOf(charFirst), String.valueOf(charLast));
            }
        }
        return result.toString();
    }
}
