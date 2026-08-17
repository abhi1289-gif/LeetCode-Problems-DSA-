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

    public boolean travel(TreeNode root, long min, long maxx){
        if(root == null) return true;

        if(root.val <= min || root.val >= maxx) return false;

        return travel(root.left, min, root.val) && travel(root.right, root.val, maxx);
    }

    public boolean isValidBST(TreeNode root) {
        return travel(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}