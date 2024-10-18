package 백준._3_골드.DFS_BFS.P1525;

import java.io.*;
import java.util.*;

public class Main {
    static String target = "123456780";
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            for (String s : input) {
                sb.append(s);
            }
        }
        String start = sb.toString();
        System.out.println(bfs(start));
    }

    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int moves = visited.get(current);
            if (current.equals(target)) {
                return moves;
            }

            int zeroIndex = current.indexOf("0");
            int x = zeroIndex / 3;
            int y = zeroIndex % 3;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    int swapIndex = nx * 3 + ny;
                    char[] chars = current.toCharArray();

                    chars[zeroIndex] = chars[swapIndex];
                    chars[swapIndex] = '0';

                    String next = new String(chars);

                    if (!visited.containsKey(next)) {
                        visited.put(next, moves + 1);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
