class Solution {
    public int longestArithSeqLength(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            maxx = Math.max(nums[i], maxx);
            minn = Math.min(nums[i], minn);
        }

        int ans = 0;

        int diff = Math.abs(maxx-minn);

        int dp[][] = new int[nums.length][(diff*2+1)];

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                int temp = diff + nums[i] - nums[j];
                if(dp[j][temp] == 0){
                    dp[i][temp] = 2;
                }
                else dp[i][temp] = Math.max(dp[i][temp], dp[j][temp] + 1);
                ans = Math.max(ans,dp[i][temp]);
            }
        }

        return ans;
    }
}