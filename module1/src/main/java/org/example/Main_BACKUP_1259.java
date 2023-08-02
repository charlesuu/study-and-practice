package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

    }



    private int countZeros(String s) {
         int zeros = 0;
         for (char c : s.toCharArray()) {
             if (c == '0') zeros++;
         }
         return zeros;
     }

     public int[] solution(String s) {
         int loop = 0;
         int removed = 0;

         while (!s.equals("1")) {
             int zeros = countZeros(s);
             loop += 1;
             removed += zeros;

             int ones = s.length() - zeros;
             s = Integer.toString(ones, 2);
         }

         return new int[] {loop, removed};
     }
}