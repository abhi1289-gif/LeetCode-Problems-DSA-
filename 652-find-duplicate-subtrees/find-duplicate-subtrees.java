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

    HashMap<String, Integer> mapp;
    List<TreeNode> ans;
    HashSet<String> used = new HashSet<>();

    public String travel(TreeNode root){
        if(root == null) return "#";

        String left = travel(root.left);
        String right = travel(root.right);

        String curr = String.valueOf(root.val) + "," + left + "," + right;
        mapp.put(curr, mapp.getOrDefault(curr, 0)+1);
        
        if(mapp.get(curr) > 1 && !used.contains(curr)){
            used.add(curr);
            ans.add(root);
        }

        return curr;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        mapp = new HashMap<>();
        ans = new ArrayList<>();
        travel(root);
        
        return ans;
    }
}