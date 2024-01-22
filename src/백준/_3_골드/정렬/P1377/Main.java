package 백준._3_골드.정렬.P1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());
            nodes[i] = new Node(i, x);
        }

        Arrays.sort(nodes);

        int index = 0;
        for (int i = 0; i < N; i++) {
            int x = nodes[i].index - i;
            index = Math.max(index, x);
        }
        System.out.println(index + 1);
    }

    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
