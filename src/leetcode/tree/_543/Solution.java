package leetcode.tree._543;

import leetcode.tree.TreeNode;

class Solution {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return this.longest;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        longest = Math.max(longest, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
