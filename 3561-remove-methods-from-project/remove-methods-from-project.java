class Solution {

    List<List<Integer>> graph;

    public void travel(int src, boolean visited[]){
        visited[src] = true;

        for(int nebr: graph.get(src)){
            if(!visited[nebr]){
                travel(nebr, visited);
            }
        }
    }

    boolean can;

    public void dfs(int src, List<Integer> temp, boolean visited[], boolean suspect[]){
        visited[src] = true;
        temp.add(src);

        for(int nebr: graph.get(src)){
            if(suspect[nebr] == true){
                can = false;
            }
            else if(!visited[nebr]) dfs(nebr, temp, visited, suspect);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int edge[]: invocations){
            graph.get(edge[0]).add(edge[1]);
        }

        boolean suspect[] = new boolean[n];

        travel(k, suspect);

        for (int edge[] : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspect[u] && suspect[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspect[i])
                ans.add(i);
        }

        return ans;
    }
}