package 백준._2_실버.DFS.P11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Node[] nodes;
    static int count = 0;
    static int rs = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from].stack.add(to);
            nodes[to].stack.add(from);
        }

        int index = 1;
        while (count < N) {
            if (!nodes[index].check) {
                rs++;
                dfs(index);
            }
            index++;
        }
        System.out.println(rs);
    }

    static void dfs(int from) {
        Node node = nodes[from];
        if (node.check) {
            return;
        }
        node.check = true;
        count++;
        while (!node.stack.isEmpty()) {
            Integer to = node.stack.pop();
            dfs(to);
        }
    }

    static class Node {
        boolean check = false;
        Stack<Integer> stack = new Stack<>();

        public Node() {
        }
    }
}
