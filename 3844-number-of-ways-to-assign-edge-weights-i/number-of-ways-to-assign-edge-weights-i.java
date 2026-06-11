class Solution {

    List<List<Integer>> graph;

    public int bfs(int n){
        Queue<Integer> qu = new LinkedList<>();
        boolean visited[] = new boolean[n];
        int depth = 0;

        qu.add(1);

        while(qu.size() > 0){
            int siz = qu.size();

            while(siz>0 ){
                int curr = qu.poll();
                visited[curr] = true;

                for(int nebr: graph.get(curr)){
                    if(!visited[nebr]) qu.add(nebr);
                }
                siz--;
            }

            depth++;
        }

        return depth-1;
    }

    int mod = 1000000007;

    public int cal(int n){
        if(n == 0) return 1;

        return (2*cal(n-1))%mod;
    }

    public int assignEdgeWeights(int[][] edges) {
        graph = new ArrayList<>();
        int n = edges.length;
        n+=2;

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int maxx = bfs(n);
        int ans = cal(maxx-1);
        return ans;
    }
}