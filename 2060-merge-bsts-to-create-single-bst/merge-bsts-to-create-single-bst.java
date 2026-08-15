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

    HashMap<Integer, TreeNode> mapp;

    public TreeNode travel(TreeNode root){
        if(root == null) return null;

        if(root.left == null && root.right == null){
            if(mapp.containsKey(root.val)){
                TreeNode temp = mapp.get(root.val);
                mapp.remove(root.val);

                temp.left = travel(temp.left);
                temp.right = travel(temp.right);

                return temp;
            }
            return root;
        }

        root.left = travel(root.left);
        root.right = travel(root.right);

        return root;
    }

    public boolean isPossible(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            if (prev != null && root.val <= prev.val)
                return false;

            prev = root;
            root = root.right;
        }

        return true;
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        mapp = new HashMap<>();
        for(TreeNode root: trees){
            mapp.put(root.val, root);
        }

        HashSet<Integer> leaves = new HashSet<>();

        for(TreeNode root : trees){
            if(root.left != null)
                leaves.add(root.left.val);

            if(root.right != null)
                leaves.add(root.right.val);
        }

        TreeNode treeMainRoot = null;

        for(TreeNode root : trees){
            if(!leaves.contains(root.val)){
                if(treeMainRoot != null) return null;
                treeMainRoot = root;
            }
        }

        if(treeMainRoot == null) return null;

        mapp.remove(treeMainRoot.val);

        treeMainRoot = travel(treeMainRoot);

        if(mapp.size() != 0) return null;

        if(isPossible(treeMainRoot)) return treeMainRoot;

        return null;
    }
}