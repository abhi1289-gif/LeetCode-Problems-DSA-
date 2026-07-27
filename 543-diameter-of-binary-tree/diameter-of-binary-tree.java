class Solution {

    int ans;

    public int travel(TreeNode root){
        if(root == null) return 0;

        int left = travel(root.left);
        int right = travel(root.right);

        int a = 1 + left + right;
        ans = Math.max(a, ans);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        travel(root);
        return ans-1;
    }
}