package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for (String name : participant) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for (String name : completion) {
            int v = count.get(name) - 1;
            count.put(name, v);
            if (v == 0)
                count.remove(name);
        }

        return count.keySet().iterator().next();
    }
}