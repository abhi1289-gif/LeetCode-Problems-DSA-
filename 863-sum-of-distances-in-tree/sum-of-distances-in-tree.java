class Solution {

    List<List<Integer>> graph;
    int[] subtreeSize;
    int[] ans;

    public void dfs(int src, int par, int depth){
        subtreeSize[src] = 1;
        ans[0] += depth;


        for(int nebr: graph.get(src)){
            if(nebr == par) continue;

            dfs(nebr, src, depth+1);
            subtreeSize[src] += subtreeSize[nebr];
        }
    }

    public void dfs2(int src, int par, int n) {
        for (int nebr : graph.get(src)) {
            if (nebr == par) continue;

            ans[nebr] = ans[src] - subtreeSize[nebr] + (n - subtreeSize[nebr]);

            dfs2(nebr, src, n);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        subtreeSize = new int[n];
        ans = new int[n];

        dfs(0, -1, 0);
        dfs2(0, -1, n);

        return ans;
    }
}