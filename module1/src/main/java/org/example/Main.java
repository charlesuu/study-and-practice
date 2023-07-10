package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Max = 2 + 500;

    static boolean[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int countPainting;
    static int maxPainting;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new boolean[Max][Max];


        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 1; j <= M; j++) {
                graph[i][j] = s[j - 1].equals("1");
            }
        }



        for (int x = 1; x <= M; x++) {
            for (int y = 1; y <= N; y++) {
                if (graph[y][x]) {
                    countPainting++;
                    bfs(x, y);
                }
            }
        }
        System.out.println(countPainting);
        System.out.println(maxPainting);

    }


    public static void bfs(int x, int y) {
        int width = 1;
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(x, y);
        que.add(node);

        while (!que.isEmpty()) {

            x = que.peek().x;
            y = que.peek().y;
            graph[y][x] = false;
            que.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (graph[newY][newX]) {
                    que.add(new Node(newX, newY));
                    width++;
                    graph[newY][newX]=false;
                }
            }
        }
        maxPainting = Math.max(maxPainting, width);
    }
}


