class Solution {

    int dp[][];

    public int travel(int idx, int n, int nums[], int prev){
        if(idx == n) return nums[prev];
        if(idx == n-1) return Math.max(nums[idx], nums[prev]);

        if(dp[idx][prev] != -1) return dp[idx][prev];

        int a = Math.max(nums[idx], nums[idx+1]) + travel(idx+2, n, nums, prev);
        int b = Math.max(nums[prev], nums[idx+1]) + travel(idx+2, n, nums, idx);
        int c = Math.max(nums[prev], nums[idx]) + travel(idx+2, n, nums, idx+1);

        return dp[idx][prev] = Math.min(a, Math.min(b, c));
    }

    public int minCost(int[] nums) {
        dp = new int[nums.length+1][nums.length+1];
        for(int i=0; i<=nums.length; i++){
            for(int j=0; j<=nums.length; j++){
                dp[i][j] = -1;
            }
        }
        return travel(1, nums.length, nums, 0);
    }
}
