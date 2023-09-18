package org.example;

import java.util.Scanner;

public class Main {

    public static int H;
    public static int W;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();

        int[] wallHeights = new int[W];

        for (int i = 0; i < W; i++) {
            wallHeights[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) { //i = pW
            int leftMaxHeights = 0;
            int rightMaxHeights = 0;

            for (int j = 0; j < i; j++) {// 좌측에서 가장 높은 벽
                leftMaxHeights = Math.max(leftMaxHeights, wallHeights[j]);
            }

            for (int j = i + 1; j < W; j++) {// 우측에서 가장 높은 벽
                rightMaxHeights = Math.max(rightMaxHeights, wallHeights[j]);
            }

            if (wallHeights[i] < leftMaxHeights && wallHeights[i] < rightMaxHeights) {//좌우측 가장 높은 벽보다 현 위치의 벽이 작은 경우
                result +=
                    Math.min(leftMaxHeights, rightMaxHeights) - wallHeights[i];//result += 좌우 벽 중 작은 벽의 높이 - 현 위치 벽의 높이
            }
        }
        System.out.println(result);
    }
}