package 백준._3_골드.트리.P11505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * segment tree
 */
public class Main {
    static long[] tree;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 1 - change 의 횟수
        int K = Integer.parseInt(st.nextToken()); // 2 - 구간 곲 값 구하기 횟수
        int length = N;
        int height = 0;
        while (length != 0) {
            height++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        int leftIndexNode = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = 0; i < treeSize + 1; i++) {
            tree[i] = 1;
        }
        for (int i = leftIndexNode + 1; i < leftIndexNode + N + 1; i++) {
            tree[i] = Integer.parseInt(bf.readLine());
        }
        setTree(treeSize - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                change(b + leftIndexNode, c);
            }
            if (a == 2) {
                long multiply = getMultiply(b + leftIndexNode, c + leftIndexNode);
                sb.append(multiply).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void setTree(int i) {
        int value = i / 2;
        while (value > 0) {
            tree[value] = (tree[value * 2] * tree[value * 2 + 1]) % MOD;
            value--;
        }
    }

    private static long getMultiply(int s, int e) {
        long rs = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                rs = (rs * tree[s]) % MOD;
                s++;
            }

            if (e % 2 == 0) {
                rs = (rs * tree[e]) % MOD;
                e--;
            }

            s /= 2;
            e /= 2;
        }
        return rs;
    }

    private static void change(int i, int v) {
        tree[i] = v;
        i /= 2;
        while (i > 0) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
            i /= 2;
        }
    }
}
