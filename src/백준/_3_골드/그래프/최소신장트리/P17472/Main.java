package 백준._3_골드.그래프.최소신장트리.P17472;

import java.util.*;
import java.io.*;

public class Main {
    static int[] X = {1, -1, 0, 0};
    static int[] Y = {0, 0, 1, -1};
    static int[][] preGeoMatrix;
    static int[][] postGeoMatrix;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue<Edge> queue = new PriorityQueue<>();
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        preGeoMatrix = new int[N][M];
        postGeoMatrix = new int[N][M];
        visited = new boolean[N][M];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                preGeoMatrix[i][j] = i1;
            }
        }
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && preGeoMatrix[i][j] == 1) {

                    bfs(i, j, ++index);
                }
            }
        }
        D = new int[index + 1];
        for (int i = 1; i < index + 1; i++) {
            D[i] = i;
        }
        // find Edge
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (postGeoMatrix[i][j] > 0) {
                    findEdge(i, j);
                }
            }
        }

        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            if (count >= index - 1) {
                break;
            }
            Edge edge = queue.poll();
            int s1 = find(edge.start);
            int s2 = find(edge.end);
            if (s1 != s2) {
                D[s2] = s1;
                count++;
                sum += edge.weight;
            }
        }
        if (count == index - 1) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }

    public static int find(int index) {
        if (D[index] == index) {
            return index;
        }
        return find(D[index]);
    }

    public static void bfs(int x, int y, int index) {
        Land land = new Land(x, y);
        Queue<Land> queue = new LinkedList<>();
        queue.offer(land);

        while (!queue.isEmpty()) {
            Land current = queue.poll();
            visited[current.x][current.y] = true;
            postGeoMatrix[current.x][current.y] = index;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + X[i];
                int nextY = current.y + Y[i];
                if (isOk(nextX, nextY) && !visited[nextX][nextY] && preGeoMatrix[nextX][nextY] == 1) {
                    queue.offer(new Land(nextX, nextY));
                }
            }
        }
    }

    public static void findEdge(int x, int y) {
        int index = postGeoMatrix[x][y];
        int count;

        for (int i = 0; i < 4; i++) {
            int dX = x;
            int dY = y;
            count = 0;
            while (true) {
                dX = dX + X[i];
                dY = dY + Y[i];
                if (!isOk(dX, dY)) {
                    break;
                }
                if (postGeoMatrix[dX][dY] == index) {
                    break;
                }
                if (postGeoMatrix[dX][dY] == 0) {
                    count++;
                } else if (count >= 2) {
                    int end = postGeoMatrix[dX][dY];
                    Edge edge = new Edge(index, end, count);
                    queue.offer(edge);
                    break;
                } else {
                    break;
                }
            }
        }
    }

    public static boolean isOk(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }
        return false;
    }
}

class Land {
    int x;
    int y;

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
