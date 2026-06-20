    class Solution {

        List<List<Integer>> graph;

        public void dfs(int src, long finish[], int base[]){
            if(finish[src] != -1) return;
            
            if(graph.get(src).isEmpty()){
                finish[src] = base[src];
                return;
            }

            long ear = Long.MAX_VALUE;
            long lat = Long.MIN_VALUE;

            for(int nebr: graph.get(src)){
                dfs(nebr, finish, base);
                
                ear = Math.min(ear, finish[nebr]);
                lat = Math.max(lat, finish[nebr]);
            }

            long own = lat-ear + base[src];
            finish[src] = lat + own;
        }
        
        public long finishTime(int n, int[][] edges, int[] baseTime) {
            graph = new ArrayList<>();
            for(int i=0; i<n; i++) graph.add(new ArrayList<>());
            
            for(int edge[]: edges){
                graph.get(edge[0]).add(edge[1]);
            }
            
            long finish[] = new long[n];
            
            for(int i=0; i<n; i++) finish[i] = -1;
            
            dfs(0, finish, baseTime);
            return finish[0];
        }
    }