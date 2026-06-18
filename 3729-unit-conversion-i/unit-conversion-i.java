class Solution {

    int mod = 1000000007;

    public class Pair{
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }

    List<List<Pair>> graph;

    public void findAns(int ans[], boolean visited[], int src, long factor){
        factor = factor%mod;

        ans[src] = (int)(factor);
        visited[src] = true;

        for(Pair nebr: graph.get(src)){
            if(!visited[nebr.node]){
                Long temp = (factor*nebr.wt)%mod;
                findAns(ans, visited, nebr.node, temp);
            }
        }
    }

    public int[] baseUnitConversions(int[][] nums) {
        int n = nums.length;
        graph = new ArrayList<>();

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        int ans[] = new int[n+1];
        boolean visited[] = new boolean[n+1];

        for(int num[]: nums){
            graph.get(num[0]).add(new Pair(num[1], num[2]));
        }

        findAns(ans, visited, 0, 1);

        return ans;
    }
}