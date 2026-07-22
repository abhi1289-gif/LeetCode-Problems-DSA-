class Solution {

    public int lca(int a, int b){
        if(a == b) return a;

        if(a > b) return lca(a/2, b);
        return lca(a, b/2);
    }

    public int depth(int a){
        int ans = 0;
        while(a > 0){
            ans++;
            a /= 2;
        }
        return ans;
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int b = lca(l, r);

            ans[i] = depth(l) + depth(r) - 2*depth(b) + 1;
        }

        return ans;
    }
}