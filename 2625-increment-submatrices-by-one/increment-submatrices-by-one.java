class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][] = new int[n][n];

        for(int nums[]: queries){
            int rs = nums[0];
            int re = nums[2];

            int cs = nums[1];
            int ce = nums[3];

            for(int i=rs; i<=re; i++){
                for(int j=cs; j<=ce; j++){
                    ans[i][j]++;
                }
            }
        }

        return ans;
    }
}