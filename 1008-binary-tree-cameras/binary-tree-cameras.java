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
        if(root == null) return 2;

        int l = travel(root.left);
        int r = travel(root.right);

        if(l==0 || r==0){
            ans++;
            return 1;
        }

        if(l==1 || r==1){
            return 2;
        }
        
        return 0;

    }

    public int minCameraCover(TreeNode root) {
        if(travel(root) == 0) ans++;
        return ans;
    }
}