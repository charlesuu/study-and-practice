package org.example;

import java.util.Scanner;

public class Main {

    public static int[][] board = new int[10][10];
    public static boolean[] checker = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            //보드 입력 받기
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    board[j][k] = sc.nextInt();
                }
            }
            //정답 검사 및 결과 출력
            if (checkRow() && checkCol() && checkBox()) {
                sb.append(String.format("Case %d: CORRECT\n", i + 1));
            } else {
                sb.append(String.format("Case %d: INCORRECT\n", i + 1));
            }
        }

        System.out.println(sb);
    }

    private static boolean checkRow() {
        for (int i = 1; i < 10; i++) {
            initChecker();
            for (int j = 1; j < 10; j++) {
                checker[board[i][j]] = true;
            }
            if (!checkChecker()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol() {
        for (int i = 1; i < 10; i++) {
            initChecker();
            for (int j = 1; j < 10; j++) {
                checker[board[j][i]] = true;
            }
            if (!checkChecker()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkBox() {
        for (int i = 1; i < 9; i += 3) {
            for (int j = 1; j < 9; j += 3) {
                initChecker();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        checker[board[k][l]] = true;
                    }
                }
                if (!checkChecker()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void initChecker() {
        for (int i = 1; i < 10; i++) {
            checker[i] = false;
        }
    }

    private static boolean checkChecker() {
        for (int i = 1; i < 10; i++) {
            if (!checker[i]) {
                return false;
            }
        }
        return true;
    }
}