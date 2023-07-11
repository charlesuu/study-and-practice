package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int[][] board;
    public static int N;
    public static int dX[] = { -1, 1, 0, 0 };
    public static int dY[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            int studentNum = sc.nextInt();
            int[] friendly = new int[4];//2차원 배열
            for (int j = 0; j < 4; j++) {
                friendly[i] = sc.nextInt();
            }
            //자리 골라 주기.

            //1. :비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            //2. :1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            //3. :2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            int r = 0;
            int c = 0;
            int maxNearPoint = 0;
            int maxEmptyPoint = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int nearPoint = 0;
                    int emptyPoint = 0;

                    if (board[j][k] != 0) {
                        continue;
                    }

                    //사방 순회
                    for (int z = 0; z < 4; z++) {
                        int x = j + dX[z];
                        int y = k + dY[z];
                        if (x <= 0 || x > N || y <= 0 || y > N) {
                            continue;
                        }
                        if (board[x][y] > 0 && (board[x][y] == friendly[0] || board[x][y] == friendly[1] || board[x][y] == friendly[2] || board[x][y] == friendly[3])) {
                            nearPoint++;
                        } else if (board[x][y] == 0) {
                            emptyPoint++;
                        }
                    }

                    if (nearPoint > maxNearPoint) {
                        maxNearPoint = nearPoint;
                        maxEmptyPoint = emptyPoint;
                        r = j;
                        c = k;
                    } else if (nearPoint == maxNearPoint && emptyPoint > maxEmptyPoint) {
                        maxNearPoint = nearPoint;
                        maxEmptyPoint = emptyPoint;
                        r = j;
                        c = k;
                    }
                }
            }
            board[r][c] = studentNum;


        }
    }
}


