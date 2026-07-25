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

    int ans = 0;

    public int travel(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;

        int l = travel(root.left);
        int r = travel(root.right);

        if(root.val >= l && root.val >= r) ans++;

        return Math.max(root.val, Math.max(l, r));
    }

    public int countDominantNodes(TreeNode root) {
        travel(root);
        return ans;
    }
}