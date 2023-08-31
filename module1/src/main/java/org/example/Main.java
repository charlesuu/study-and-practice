package org.example;


import java.util.Arrays;

public class Main {

    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

    public static void main(String[] args) {

    }

}