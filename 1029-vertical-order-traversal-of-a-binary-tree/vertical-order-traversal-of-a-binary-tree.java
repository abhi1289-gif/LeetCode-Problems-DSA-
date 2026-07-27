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
    
    public class Pair{
        int row;
        int val;

        Pair(int row, int val){
            this.row = row;
            this.val = val;
        }
    }

    int minn;
    int maxx;

    HashMap<Integer, List<Pair>> mapp;

    public void travel(TreeNode root, int row, int col){
        if(root == null) return;

        minn = Math.min(minn, col);
        maxx = Math.max(maxx, col);

        if(!mapp.containsKey(col)) mapp.put(col, new ArrayList<>());
        mapp.get(col).add(new Pair(row, root.val));

        travel(root.left, row+1, col-1);
        travel(root.right, row+1, col+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        minn = 0;
        maxx = 0;
        mapp = new HashMap<>();
        travel(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=minn; i<=maxx; i++){
            List<Pair> list = mapp.get(i);
            Collections.sort(list, (a, b) -> {
                if (a.row == b.row)
                    return a.val - b.val;
                return a.row - b.row;
            });
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<list.size(); j++){
                temp.add(list.get(j).val);
            }
            ans.add(temp);
        }

        return ans;
    }
}