package goorm.이카운트.하늘다리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class MainV2 {
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int length = N;
        int treeHight = 0;
        while (length != 0) {
            treeHight++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, treeHight + 1);
        tree = new int[treeSize + 1];

        int leftIndex = treeSize / 2 - 1;

        int[] heightArr = new int[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            heightArr[i] = x;
            tree[leftIndex + i + 1] = x;
        }

        setTree(treeSize / 2 - 1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(heightArr[i])) {
                Integer index = map.get(heightArr[i]);
                int max = getMax(leftIndex + index + 1, leftIndex + i);
                if (max <= heightArr[i]) {
                    count++;
                }
            }
            map.put(heightArr[i], i);
        }
        System.out.println(count);
    }

    private static void setTree(int index) {
        while (index > 0) {
            tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
            index /= 2;
        }
    }

    private static int getMax(int start, int end) {
        int max = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                if (max < tree[start]) max = tree[start];
                start++;
            }
            if (end % 2 == 0) {
                if (max < tree[end]) max = tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }
        return max;
    }
}
