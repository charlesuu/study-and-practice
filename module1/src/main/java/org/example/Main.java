package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        int count = sc.nextInt();

        int max = 0;
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            list.add(num);
            if (num > max) {
                max = num;
            }
        }

        int dp[] = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 3] +dp[i - 2] +dp[i - 1];
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            System.out.println(dp[num]);
        }
    }
}


