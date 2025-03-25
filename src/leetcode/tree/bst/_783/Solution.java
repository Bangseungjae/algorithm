package leetcode.tree.bst._783;

import leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 재귀 방식
//class Solution {
//    int prev = Integer.MIN_VALUE + 100000;
//    int minDiff = Integer.MAX_VALUE;
//    public int minDiffInBST(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left != null) minDiffInBST(root.left);
//
//        minDiff = Math.min(minDiff, root.val - prev);
//        prev = root.val;
//        if (root.right != null) minDiffInBST(root.right);
//        return minDiff;
//    }
//}

// 반복 구조 방식
class Solution {
    public int minDiffInBST(TreeNode root) {
        int prev = Integer.MIN_VALUE + 100_000;
        int minDiff = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            minDiff = Math.min(minDiff, node.val - prev);

            prev = node.val;
            node = node.right;
        }
        return minDiff;
    }
}