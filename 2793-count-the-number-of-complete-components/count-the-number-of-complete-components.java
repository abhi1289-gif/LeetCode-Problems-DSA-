class Solution {

    int v;
    int e;

    List<List<Integer>> graph;

    public void travel(int src, boolean visited[]){
        v++;
        visited[src] = true;

        for(int nebr: graph.get(src)){
            e++;
            if(!visited[nebr]){
                travel(nebr, visited);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int edge[]: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        int ans = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                v = 0;
                e = 0;
                travel(i, visited);
                e /= 2;
                if(v == 1){
                    ans++;
                    continue;
                }
                if(e == v*(v-1)/2) ans++;
            }
        }

        return ans;
    }
}