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

    List<Integer> nums;

    public int findSmaller(int a){
        int i = 0;
        int j = nums.size()-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums.get(mid) == a) return a;
            if(nums.get(mid) < a){
                i = mid+1;
                ans = nums.get(mid);
            }
            else{
                j = mid-1;
            }
        }

        return ans;
    }

    public int findLarger(int a){
        int i = 0;
        int j = nums.size()-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums.get(mid) == a) return a;
            if(nums.get(mid) < a){
                i = mid+1;
            }
            else{
                ans = nums.get(mid);
                j = mid-1;
            }
        }

        return ans;
    }

    public void travel(TreeNode root){
        if(root == null) return;

        travel(root.left);
        nums.add(root.val);
        travel(root.right);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        nums = new ArrayList<>();
        travel(root);

        List<List<Integer>> ans = new ArrayList<>();

        for(int qu: queries){
            ans.add(Arrays.asList(findSmaller(qu), findLarger(qu)));
        }

        return ans;
    }
}