class Solution {

    public class TreeNode{
        int val;
        List<TreeNode> nebr;
        int depth;
        int par;

        TreeNode(int val, int par){
            this.val = val;
            this.nebr = new ArrayList<>();
            this.depth = -1;
            this.par = par;
        }
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int maxx = 0;
        for(TreeNode nebr: root.nebr){
            maxx = Math.max(maxx, height(nebr));
        }        
        return 1 + maxx;
    }

    public long travel(TreeNode root, int height){
        long ans = 0;
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        root.depth = 1;

        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            ans += (long)(curr.val)*(height-curr.depth+1);

            for(TreeNode nebr: curr.nebr){
                nebr.depth = curr.depth+1;
                qu.add(nebr);
            }
        }

        return ans;
    }

    public long weightedSum(int[] parent, int[] nums) {
        TreeNode nodes[] = new TreeNode[nums.length];

        for(int i=0; i<nums.length; i++){
            nodes[i] = new TreeNode(nums[i], parent[i]);
        }

        for(int i=1; i<nums.length; i++){
            int par = parent[i];
            nodes[par].nebr.add(nodes[i]);
        }

        TreeNode root = nodes[0];
        int height = height(root);
        return travel(root, height);
    }
}