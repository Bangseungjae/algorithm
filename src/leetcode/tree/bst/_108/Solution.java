package leetcode.tree.bst._108;

import leetcode.tree.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, lo, mid - 1);
        node.right = construct(nums, mid + 1, hi);
        return node;
    }
}