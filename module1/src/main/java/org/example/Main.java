package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final String VISITED = "X";
    private static int n;

    public static void dfs(int x, int y, String[][] board) {
        String color = board[x][y];
        board[x][y] = VISITED;
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < n) && board[nx][ny].equals(color)) {
                dfs(nx, ny, board);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String[][] board1 = new String[n][n];
        String[][] board2 = new String[n][n];
        int result1 = 0;
        int result2 = 0;
        String color;

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                color = tokens[j];
                board1[i][j] = color;
                board2[i][j] = color.equals("G") ? "R" : color;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!board1[i][j].equals(VISITED)) {
                    dfs(i, j, board1);
                    result1 += 1;
                }

                if (!board2[i][j].equals(VISITED)) {
                    dfs(i, j, board2);
                    result2 += 1;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }
}