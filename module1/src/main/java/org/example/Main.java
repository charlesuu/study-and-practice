package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }


            int max = -1;
            long margin = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    margin += max - arr[j];
                }
            }
            System.out.println(margin);
        }
    }
}


