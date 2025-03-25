package leetcode.tree._297;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf("#," + root.val));
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                sb.append(String.valueOf("," + cur.left.val));
            } else {
                sb.append(",#");
            }
            if (cur.right != null) {
                queue.add(cur.right);
                sb.append(String.valueOf("," + cur.right.val));
            } else {
                sb.append(",#");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        queue.add(root);
        int index = 2;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index += 1;
            if (!nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index += 1;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));