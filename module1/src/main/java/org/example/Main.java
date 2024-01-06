package org.example;

import java.util.Scanner;

//recall
public class Main {

    public static final boolean[] selected = new boolean[9];
    public static final int[] selectSpace = new int[9];

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        permutation(1);

        System.out.println(sb);
    }

    private static void permutation(int depth) {
        if (depth == M + 1) {
            print();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            selectSpace[depth] = i;
            permutation(depth + 1);

            selected[i] = false;
        }


    }

    private static void print() {
        for (int i = 1; i < M; i++) {
            sb.append(selectSpace[i]).append(" ");
        }
        sb.append("\n");
    }
}





