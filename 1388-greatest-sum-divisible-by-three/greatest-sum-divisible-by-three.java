class Solution {
    
    int dp[][];

    public int travel(int idx, int rem, int nums[]){
        if(idx == nums.length) return rem == 0 ? 0 : Integer.MIN_VALUE;

        if(dp[idx][rem] != -1) return dp[idx][rem];

        int a = travel(idx+1, rem, nums);


        int b = travel(idx+1, (rem+nums[idx])%3, nums);
        if(b != Integer.MIN_VALUE){
            b += nums[idx];
        }

        return dp[idx][rem] = Math.max(a, b);
    }

    public int maxSumDivThree(int[] nums) {
        dp = new int[nums.length][3];

        for(int i=0; i<nums.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }

        return travel(0, 0, nums);
    }
}