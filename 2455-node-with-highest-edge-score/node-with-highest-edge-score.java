class Solution {
    public int edgeScore(int[] edges) {
        long indegree[] = new long[edges.length];

        for(int i=0; i<edges.length; i++){
            indegree[edges[i]] += (long)i;
        }

        int ans = -1;
        long maxx = -1;

        for(int i=0; i<edges.length; i++){
            if(maxx < indegree[i]){
                maxx = indegree[i];
                ans = i;
            }
        }

        return ans;
    }
}