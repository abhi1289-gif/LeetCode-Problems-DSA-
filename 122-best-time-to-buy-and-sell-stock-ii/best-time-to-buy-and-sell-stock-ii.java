class Solution {

    int dp[][];

    public int travel(int idx, int buy, int nums[]){
        if(idx == nums.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;

        if(buy == 1){
            profit = Math.max(-nums[idx] + travel(idx+1, 0, nums), travel(idx+1, 1, nums));
        }
        else{
            profit = Math.max(nums[idx] + travel(idx+1, 1, nums), travel(idx+1, 0, nums));
        }

        return dp[idx][buy] = profit;
    }

    public int maxProfit(int[] nums) {
        dp = new int[nums.length+1][2];
        for(int i=0; i<nums.length+1; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return travel(0, 1, nums);
    }
}