package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    public static void main(String[] args) {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Main main = new Main();
        int[] answer = main.solution(places);
        for (int i = 0; i < 5; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];


        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            //toCharArray()로 new char[]생성 후 새로만든 room2차원 배열의 원소로 할당
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            //룸 하나에 대한 탐색 & answer에 걸과 입력
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;

            switch (room[ny][nx]) {
                case 'P': return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3- d)) return false;
                    break;
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
}