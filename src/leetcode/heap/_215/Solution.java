package leetcode.heap._215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        BinaryHeap heap = new BinaryHeap();

        for (int n : nums)
            heap.insert(n);

        for (int i = 0; i < k - 1; i++) {
            heap.extract();
        }
        return heap.extract();
    }
}

