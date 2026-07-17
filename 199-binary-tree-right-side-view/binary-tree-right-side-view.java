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

    List<Integer> ans;

    public void travel(TreeNode root, int depth){
        if(root == null) return;
        
        if(ans.size() < depth) ans.add(root.val);

        travel(root.right, depth+1);
        travel(root.left, depth+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();

        travel(root, 1);

        return ans;
    }
}