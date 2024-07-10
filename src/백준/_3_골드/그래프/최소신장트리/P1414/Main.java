package 백준._3_골드.그래프.최소신장트리.P1414;

import java.io.*;
import java.util.*;

public class Main {
    static Queue<Edge> queue = new PriorityQueue();
    static int N;
    static int sum = 0;
    static int[][] A;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        parent = new int[N + 1];
        A = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            String str = bf.readLine();
            char[] charArray = str.toCharArray();

            for (int j = 1; j < N + 1; j++) {
                char c = charArray[j - 1];
                int n = 0;
                if (c >= 'a' && c <= 'z') {
                    n = c - 97 + 1;
                } else if(c >= 'A' && c <= 'Z'){
                    n = c - 'A' + 27;
                }
                sum += n;
                if (i != j && n != 0) {
                    Edge edge = new Edge(i, j, n);
                    queue.offer(edge);
                }
            }
        }
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        while (!queue.isEmpty()) {
            if (count >= N - 1) {
                break;
            }
            Edge current = queue.poll();
            int s1 = find(current.start);
            int s2 = find(current.end);

            if (s1 != s2) {
                parent[s2] = s1;
                count++;
                sum -= current.weight;
            }
        }

        if (count == N - 1) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }


    }

    public static int find(int index) {
        if (parent[index] == index) return index;

        return find(parent[index]);
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
