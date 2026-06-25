class Solution {
    public int minFallingPathSum(int[][] nums) {
        int n = nums.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;
                if(j-1 >= 0) a = nums[i-1][j-1];
                b = nums[i-1][j];
                if(j+1 < n) c = nums[i-1][j+1];
                nums[i][j] = nums[i][j] + Math.min(a, Math.min(b, c));
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            ans = Math.min(ans, nums[n-1][i]);
        }

        return ans;
    }
}