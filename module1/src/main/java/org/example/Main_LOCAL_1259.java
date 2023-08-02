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
        HashMap<String, String> hashMap = new HashMap<>();
    }

    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = Arrays.stream(ability)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }
}