/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String travel(TreeNode root, StringBuilder ans) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();

            if (curr == null) {
                ans.append("#,");
                continue;
            }

            ans.append(curr.val).append(",");

            qu.offer(curr.left);
            qu.offer(curr.right);
        }
        return ans.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        travel(root, ans);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nums[] = data.split(",");
        if(nums[0].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(nums[0]));

        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        int i = 1;

        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            String left = nums[i++];
            boolean flag = false;
            if(i < nums.length) flag = true;
            String right = "#";
            if(flag) right = nums[i++];

            if(!left.equals("#")){
                TreeNode temp = new TreeNode(Integer.valueOf(left));
                curr.left = temp;
                qu.add(temp);
            }

            if(flag && !right.equals("#")){
                TreeNode temp = new TreeNode(Integer.valueOf(right));
                curr.right = temp;
                qu.add(temp);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;