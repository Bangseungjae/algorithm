package 백준._3_골드.그래프.최소신장트리.P1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        Integer V = Integer.parseInt(s[0]);
        Integer E = Integer.parseInt(s[1]);
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            list.add(new Edge(start, end, weight));
        }
        Collections.sort(list);
        int sum = 0;
        int[] vArr = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            vArr[i] = i;
        }

        for (Edge edge : list) {
            int s1 = find(vArr, edge.start);
            int s2 = find(vArr, edge.end);
            if (s1 != s2) {
                vArr[s2] = s1;
                sum += edge.weight;
            }
        }
        System.out.println(sum);
    }
    public static int find(int[] arr, int index) {
        int node = arr[index];
        if (node == index) {
            return index;
        }

        return find(arr, node);
    }
}



class Edge implements Comparable<Edge> {
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
