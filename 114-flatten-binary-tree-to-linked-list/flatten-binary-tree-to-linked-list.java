/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode dummy = new TreeNode(0);
    TreeNode temp = dummy;

    public void travel(TreeNode root){
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        temp.right = root;
        temp.left = null;
        temp = root;

        travel(left);
        travel(right);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;

        travel(root);

        temp.left = null;
    }
}