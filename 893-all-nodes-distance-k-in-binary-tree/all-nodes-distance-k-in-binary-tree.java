/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    HashMap<Integer, List<Integer>> graph;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);

        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            int a = curr.val;
            if(!graph.containsKey(a)) graph.put(a, new ArrayList<>());

            if(curr.left != null){
                qu.add(curr.left);
                int v = curr.left.val;
                graph.get(a).add(v);
                if(!graph.containsKey(v)) graph.put(v, new ArrayList<>());
                graph.get(v).add(a);
            }
            if(curr.right != null){
                qu.add(curr.right);
                int v = curr.right.val;
                graph.get(a).add(v);
                if(!graph.containsKey(v)) graph.put(v, new ArrayList<>());
                graph.get(v).add(a);
            }
        }

        int t = target.val;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(t);

        while(q.size() > 0){
            if(k == 0) break;
            int siz = q.size();
            k--;
            while(siz > 0){
                siz--;
                int curr = q.poll();
                visited.add(curr);

                for(int nebr: graph.get(curr)){
                    if(!visited.contains(nebr)){
                        q.add(nebr);
                    }
                }
                
            }
        }

        while(q.size() > 0){
            ans.add(q.poll());
        }

        return ans;

    }
}