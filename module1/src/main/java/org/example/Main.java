package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 4, 5, 6};
        Main sol = new Main();
        sol.solution(input);
    }

    public int solution(int[] cards) {

        visited = new boolean[cards.length];

        List<Integer> cntList = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;
            cnt = 1;
            visited[i] = true;
            recursive(cards, cards[i] - 1);
            cntList.add(cnt);
        }
        System.out.println("cntList = " + cntList);

        cntList.sort(Comparator.reverseOrder());

        if (cntList.size() < 2) {
            return 0;
        } else {
            return cntList.get(0) * cntList.get(1);
        }
    }

    int cnt = 0;
    boolean[] visited;

    public void recursive(int[] cards, int idx) {
        if (visited[idx]) return;

        visited[idx] = true;
        cnt++;
        recursive(cards, cards[idx] - 1);
    }
}