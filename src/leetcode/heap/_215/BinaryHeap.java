package leetcode.heap._215;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    public List<Integer> elems;

    public BinaryHeap() {
        this.elems = new ArrayList<>();
        this.elems.add(null);
    }

    public void swap(int i, int j) {
        int temp = elems.get(i);
        elems.set(i, elems.get(j));
        elems.set(j, temp);
    }

    public void percolateUp() {
        int idx = elems.size() - 1;
        int parentIdx = idx / 2;

        while (parentIdx > 0) {
            if (elems.get(idx) > elems.get(parentIdx)) {
                swap(idx, parentIdx);
            }
            idx = parentIdx;
            parentIdx = idx / 2;
        }
    }

    public void insert(int k) {
        elems.add(k);
        percolateUp();
    }

    public void maxHeapify(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        int largest = i;

        if (left < elems.size() && elems.get(left) > elems.get(largest)) {
            largest = left;
        }
        if (right < elems.size() && elems.get(right) > elems.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }

    public int extract() {
        // 루트 값 추출, 최대 힙이므로 가장 큰 값
        int extracted = elems.get(1);

        elems.set(1, elems.get(elems.size() - 1));
        elems.remove(elems.size() - 1);
        maxHeapify(1);
        return extracted;
    }
}
