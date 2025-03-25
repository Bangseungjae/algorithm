package leetcode.tree._104;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// 1ms
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            depth += 1;
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return depth;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode root = treeNode;
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(22);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}