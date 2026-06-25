class Solution {

    List<List<Integer>> graph;
    int dp[][];

    public int travel(int coins[], int curr, int k, int mul, int par){

        if(dp[curr][mul] != -1) return dp[curr][mul];
        int a = 0;
        int num = coins[curr];

        num = coins[curr] >> mul;

        int div = num/2;
        int ndiv = num-k;

        for(int nebr: graph.get(curr)){
            if(nebr == par) continue;
            div += travel(coins, nebr, k, Math.min(mul + 1, 15), curr);
        }

        for(int nebr: graph.get(curr)){
            if(nebr == par) continue;
            ndiv += travel(coins, nebr, k, mul, curr);
        }

        return dp[curr][mul] = Math.max(div, ndiv);
    }   

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        graph = new ArrayList<>();
        int n = coins.length;

        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int edge[]: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dp = new int[n+1][16];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=15; j++){
                dp[i][j] = -1;
            }
        }

        return travel(coins, 0, k, 0, -1);
    }
}