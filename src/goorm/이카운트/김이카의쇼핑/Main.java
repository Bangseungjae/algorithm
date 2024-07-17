package goorm.이카운트.김이카의쇼핑;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        int length = N;
        int height = 0;
        while (length != 0) {
            height++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        tree = new long[treeSize + 1];

        int leftIndex = treeSize / 2 - 1;

        st = new StringTokenizer(bf.readLine());
        for (int i = leftIndex + 1; i < N + leftIndex + 1; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }
        setTree(treeSize - 1);

        int count = 0;

        for (int i = leftIndex + 1; i < leftIndex + N + 1; i++) {
            for (int j = i; j < leftIndex + N + 1; j++) {
                long sum = getSum(i, j);
                if (sum >= L && sum <= R) count++;
            }
        }


        System.out.println(count);
    }


    private static void setTree(int index) {
        while (index != 1) {
            tree[index / 2] += tree[index];
            index--;
        }
    }


    private static long getSum(int start, int end) {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }
        return sum;
    }
}
