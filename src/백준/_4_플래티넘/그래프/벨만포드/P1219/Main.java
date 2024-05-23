package 백준._4_플래티넘.그래프.벨만포드.P1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        List<Integer> cityMoney = new ArrayList<>();
        long distance[] = new long[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, w));
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(distance, Long.MIN_VALUE);
        distance[start] = cityMoney.get(start);

        for (int i = 0; i < N + 100; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges.get(j);
                if (distance[edge.start] == Long.MIN_VALUE) continue;
                else if (distance[edge.start] == Long.MAX_VALUE) distance[edge.end] = Long.MAX_VALUE;
                else if (distance[edge.end] < distance[edge.start] + cityMoney.get(edge.end) - edge.value) {
                    if (i >= N) {
                        distance[edge.end] = Long.MAX_VALUE;
                    } else {
                        distance[edge.end] = distance[edge.start] + cityMoney.get(edge.end) - edge.value;
                    }
                }
            }
        }

        if (distance[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (distance[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(distance[end]);
        }
    }
}

class Edge {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
