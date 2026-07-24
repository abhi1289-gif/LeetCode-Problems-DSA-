class Solution {

    public class Pair{
        TreeNode root;
        int idx;

        Pair(TreeNode root, int idx){
            this.root = root;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 0));
        int ans = 1;

        while(qu.size() > 0){
            int siz = qu.size();
            int minn = -1;
            int maxx = -1;

            while(siz > 0){
                siz--;
                Pair curr = qu.poll();
                if(minn == -1) minn = curr.idx;
                maxx = curr.idx;
                
                if(curr.root.left != null) qu.add(new Pair(curr.root.left, 2 * curr.idx + 1));
                if(curr.root.right != null) qu.add(new Pair(curr.root.right, 2 * curr.idx + 2));
            }

            ans = Math.max(ans, maxx-minn+1);
        }

        return ans;
    }
}