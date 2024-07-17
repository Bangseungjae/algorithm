package 백준._3_골드.트리.P10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세그먼트 트리
 */
public class Main {
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = N;
        int height = 0;
        while (length != 0) {
            height++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        int leftNodeIndex = treeSize / 2 - 1;
        tree = new int[treeSize + 1];
        for (int i = 0; i < treeSize + 1; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = leftNodeIndex + 1; i < N + leftNodeIndex + 1; i++) {
            tree[i] = Integer.parseInt(bf.readLine());
        }
        setTree(treeSize - 1);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = getMin(a + leftNodeIndex, b + leftNodeIndex);
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    // tree size을 받는다.
    private static void setTree(int i) {
        int v = i / 2;
        while (v >= 1) {
            tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
            v--;
        }
    }

    private static int getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                if (min > tree[s]) {
                    min = tree[s];
                }
                s++;
            }
            if (e % 2 == 0) {
                if (min > tree[e]) {
                    min = tree[e];
                }
                e--;
            }

            s /= 2;
            e /= 2;
        }
        return min;
    }
}
