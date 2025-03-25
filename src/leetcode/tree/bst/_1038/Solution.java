package leetcode.tree.bst._1038;

import leetcode.tree.TreeNode;

class Solution {
    int val;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        val += root.val;
        root.val = val;
        bstToGst(root.left);

        return root;
    }
}