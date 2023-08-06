package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    private static final char[] CHARS = "AEIOU".toCharArray();

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }

    public int solution(String word) {
        return generate("").indexOf(word);
    }
}