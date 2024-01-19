package 백준._4_플래티넘.P11003;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!queue.isEmpty() && queue.getLast().value > now) {
                queue.removeLast();
            }
            queue.addLast(new Node(now, i));
            if (queue.getFirst().index <= i - L) {
                queue.removeFirst();
            }
            bw.write(queue.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
