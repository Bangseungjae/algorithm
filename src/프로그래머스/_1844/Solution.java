package 프로그래머스._1844;

import java.util.*;

class Solution {
    static class Position implements Comparable<Position> {
        int y;
        int x;
        int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public int compareTo(Position o) {
            return this.distance - o.distance;
        }
    }

    Queue<Position> pq = new PriorityQueue<>();

    public void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0 &&
                y < maps.length &&
                x >= 0 &&
                x < maps[y].length &&
                maps[y][x] != 0

        ) {
            maps[y][x] = 1;
            pq.add(new Position(y, x, distance + 1));
        }
    }

    public int solution(int[][] maps) {
        pq.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Position cur = pq.poll();

            if (!dist.containsKey(cur.y * 1000 + cur.x)) {
                dist.put(cur.y * 1000 + cur.x, cur);

                findPath(cur.y, cur.x + 1, cur.distance, maps);
                findPath(cur.y, cur.x - 1, cur.distance, maps);
                findPath(cur.y + 1, cur.x, cur.distance, maps);
                findPath(cur.y - 1, cur.x, cur.distance, maps);
            }
        }

        if (dist.containsKey((maps.length - 1) * 1000 + maps[0].length - 1)) {
            return dist.get((maps.length - 1) * 1000 + maps[0].length - 1).distance;
        }

        return -1;
    }
}