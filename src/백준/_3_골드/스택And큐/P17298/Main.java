package 백준._3_골드.스택And큐.P17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            while (!stack.isEmpty() && stack.peek().value < x) {
                Node node = stack.peek();
                stack.pop();
                arr[node.index] = x;
            }
            stack.push(new Node(i, x));
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            arr[node.index] = -1;
        }
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
