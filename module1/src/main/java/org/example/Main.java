package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] dwf = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int height = sc.nextInt();

            dwf[i] = height;
            sum += height;
        }
        Arrays.sort(dwf);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwf[i] - dwf[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        System.out.println(dwf[k]);
                    }
                    return;
                }
            }
        }

    }
}