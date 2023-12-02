package 백준.실버.스택and큐.P1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;

        if (queue.isEmpty()) {
            System.out.println("NO");
            return;
        }

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            int peek = stack.isEmpty() ? 0 : stack.peek();
            if (!stack.isEmpty() && peek == x) {
                stack.pop();
                stringBuilder.append("-\n");
            } else if (peek < x) {

                while (peek < x) {
                    i++;
                    stack.push(i);
                    stringBuilder.append("+\n");
                    peek = stack.peek();
                }
                stack.pop();
                stringBuilder.append("-\n");
            } else if(peek > x) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(stringBuilder);

    }
}
