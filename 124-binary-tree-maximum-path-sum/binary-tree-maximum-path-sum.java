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

    int ans = Integer.MIN_VALUE;

    public int travel(TreeNode root){
        if(root == null) return 0;

        int leftSum = travel(root.left);
        int rightSum = travel(root.right);

        leftSum = (leftSum < 0)? 0: leftSum;
        rightSum = (rightSum < 0)? 0: rightSum;

        ans = Math.max(ans, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(TreeNode root) {
        travel(root);
        return ans;
    }
}