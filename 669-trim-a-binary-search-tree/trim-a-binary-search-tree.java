class Solution {

    public TreeNode delete(TreeNode root, int l, int h){
        if(root == null) return null;

        if(root.val < l){
            if(root.right!=null) return delete(root.right, l, h);
            return null;
        }
        if(root.val > h){
            if(root.left != null) return delete(root.left, l, h);
            return null;
        }

        root.left = delete(root.left, l, h);
        root.right = delete(root.right, l, h);

        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        root = delete(root, low, high);
        return root;
    }
}