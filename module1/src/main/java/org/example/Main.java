package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


    }

    public String solution(String inputString) {
        inputString = "." + inputString + ".";

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (inputString.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.length() == 0)
            return "N";
        return builder.toString();
    }
}