package org.example;

import java.util.Scanner;

public class Main {

    private static boolean[] switchs;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        switchs = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            switchs[i] = (sc.nextInt() == 1) ? true : false;
        }

        int studentCount = sc.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (sc.nextInt() == 1) {
                male(sc.nextInt());
            } else {
                female(sc.nextInt());
            }
        }

        System.out.println(printSwitchs());
    }

    private static String printSwitchs() {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (switchs[i] == true) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
            count++;

            if (count % 20 == 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private static void male(int switchNum) {
        for (int i = switchNum; i <= N; i += switchNum) {
            switchs[i] = !switchs[i];
        }
    }

    private static void female(int switchNum) {
        switchs[switchNum] = !switchs[switchNum];

        int preNum = switchNum - 1;
        int postNum = switchNum + 1;
        while (true) {
            if ((1 <= preNum && postNum <= N) && (switchs[preNum] == switchs[postNum])) {
                switchs[preNum] = !switchs[preNum];
                switchs[postNum] = !switchs[postNum];
            } else {
                break;
            }

            preNum = preNum - 1;
            postNum = postNum + 1;
        }
    }
}