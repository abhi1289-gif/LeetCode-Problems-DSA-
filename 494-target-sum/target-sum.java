class Solution {

    int dp[][];
    int ofset;

    public int make(int idx, int sum, int target, int nums[]){
        if(idx == nums.length){
            return (sum == target)? 1: 0;
        }
        if(dp[idx][ofset+sum] != -1) return dp[idx][ofset+sum];

        int a = make(idx+1, sum-nums[idx], target, nums);
        int b = make(idx+1, sum+nums[idx], target, nums);

        return dp[idx][ofset+sum] = a+b;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int t = 0;
        for(int i=0; i<nums.length; i++) t += nums[i];
        ofset = t;
        if(Math.abs(target) > t) return 0;

        dp = new int[nums.length][t*2+1];

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=t*2; j++){
                dp[i][j] = -1;
            }
        }
        return make(0, 0, target, nums);
    }
}