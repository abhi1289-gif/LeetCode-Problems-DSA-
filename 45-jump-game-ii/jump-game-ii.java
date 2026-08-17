class Solution {

    int dp[];

    public int travel(int idx, int nums[]){
        if(idx == nums.length-1){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        if(idx >= nums.length || nums[idx] == 0) return dp[idx] = Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        for(int k=1; k<=Math.min(nums.length-1-idx, nums[idx]); k++){
            int temp = travel(idx+k, nums);
            if(temp != Integer.MAX_VALUE) ans = Math.min(ans, temp+1);
        }

        return dp[idx] = ans;
    }

    public int jump(int[] nums) {
        dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = -1;
        }
        int ans = travel(0, nums);
        return ans == Integer.MAX_VALUE? -1: ans;
    }
}