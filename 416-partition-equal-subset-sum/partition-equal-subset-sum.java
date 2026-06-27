class Solution {

    Boolean dp[][];

    public boolean isPossible(int idx, int nums[], int t, int sum){
        if(sum == t) return true;
        if(idx == nums.length) return false;
        if(sum > t) return  false;

        if(dp[idx][sum] != null) return dp[idx][sum];

        boolean take = false;
        boolean skip = false;

        take = isPossible(idx+1, nums, t, sum+nums[idx]);
        skip = isPossible(idx+1, nums, t, sum);

        return dp[idx][sum] = take || skip;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        dp = new Boolean[nums.length+1][target+1];
        return isPossible(0, nums, target, 0);
    };

}