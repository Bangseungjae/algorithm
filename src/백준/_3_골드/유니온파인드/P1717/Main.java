package 백준._3_골드.유니온파인드.P1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        for (int i = 0; i < M; i++) {

        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
