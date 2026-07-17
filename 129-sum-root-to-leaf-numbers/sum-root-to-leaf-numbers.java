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

    int ans;

    public void travel(TreeNode root, int val){
        if(root == null) return;

        val = val*10 + root.val;

        if(root.left == null && root.right == null){
            ans += val;
            return;
        }

        travel(root.left, val);
        travel(root.right, val);
    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        travel(root, 0);
        return ans;
    }
}