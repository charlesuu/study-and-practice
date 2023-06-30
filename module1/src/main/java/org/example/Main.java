package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] tmpA = new int[N];

        int[] B = new int[N];
        boolean[] visitedB = new boolean[N];


        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int aCount = 0;
        for (int i = 0; i < N; i++) {
            int max = -1;
            int maxIndex = -1;

            for (int j = 0; j < N; j++) {
                if (B[j] > max && visitedB[j] == false) {
                    visitedB[j] = true;

                    if (maxIndex != -1) {
                        visitedB[maxIndex] = false;
                    }
                    max = B[j];
                    maxIndex = j;
                }
            }

            tmpA[maxIndex] = A[aCount];
            aCount++;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += tmpA[i] * B[i];
        }
        System.out.println(answer);
    }
}


