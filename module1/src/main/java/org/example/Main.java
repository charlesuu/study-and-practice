package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static int N, K, L;
    public static int[][] board;
    public static int[] dirX = {-1, 0, 1, 0};
    public static int[] dirY = {0, 1, 0, -1};

    public static int second = 0;

    public static Deque<String[]> dirChanges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];

        K = sc.nextInt();

        //사과 배치
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            board[x][y] = 2;//사과는 2
        }

        L = sc.nextInt();
        dirChanges = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            String line = sc.nextLine();
            dirChanges.offer(line.split(" "));
        }

        int result = play();
    }

    private static int play() {
        int dir = 1;
        int X = 0;
        int Y = 0;
        board[0][0] = 1;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[] {0, 0});

        while (true) {
            int nX = X + dirX[dir];
            int nY = Y + dirY[dir];

            second++;
        }

        return 0;
    }
}