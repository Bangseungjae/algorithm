package 백준._3_골드.트리.P2042;

import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간합의 횟수

        int length = N;
        int height = 0;
        while (length != 0) {
            height++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        tree = new long[treeSize + 1];
        int leftNodeStartIndex = treeSize / 2 - 1;
        for (int i = leftNodeStartIndex + 1; i <= N + leftNodeStartIndex; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) {
                s = leftNodeStartIndex + s;
                e = leftNodeStartIndex + e;
                long sum = getSum(s, (int)e);
                System.out.println(sum);
            } else {
                return;
            }
        }

        bf.close();
    }


    // 구간 합을 구하는 함수
    private static long getSum(int s, int e) {
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s];
                s++;
            }

            if (e % 2 == 0) {
                partSum += tree[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return partSum;
    }

    // 값을 변경하는 함수
    private static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }
    }

    // 초기 트리를 구성하는 함수
    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
