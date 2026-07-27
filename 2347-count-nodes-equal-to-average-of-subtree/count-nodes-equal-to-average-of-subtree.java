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

    public int[] travel(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int left[] = travel(root.left);
        int right[] = travel(root.right);

        int sum = left[0] + right[0] + root.val;
        int num = left[1] + right[1] + 1;

        int a = sum/num;
        if(a == root.val) ans++;

        return new int[]{sum, num};
    }

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        travel(root);
        return ans;
    }
}