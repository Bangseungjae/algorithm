package leetcode.stack_queue._973;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));
        for (int[] p : points) {
            pq.add(new Point(p[0] * p[0] + p[1] * p[1], p));
        }
        int[][] rs = new int[k][];
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            rs[i] = p.point;
        }
        return rs;
    }
}

class Point {
    double distance;
    int[] point;

    Point(double distance, int[] point) {
        this.distance = distance;
        this.point = point;
    }
}
