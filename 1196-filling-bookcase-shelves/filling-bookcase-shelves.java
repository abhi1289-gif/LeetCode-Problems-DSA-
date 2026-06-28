class Solution {

    int dp[][];

    public int travel(int idx, int nums[][], int currh, int rem, int width){
        int maxx = Math.max(currh, nums[idx][1]);
        if(idx == nums.length-1){
           if(nums[idx][0] <= rem) return maxx;
           return currh + nums[idx][1];
        }

        if(dp[idx][rem] != 0) return dp[idx][rem];
        
        int num[] = nums[idx];

        int a = Integer.MAX_VALUE;

        if(rem-num[0] >= 0) a = travel(idx+1, nums, maxx, rem-num[0], width);

        int b = currh + travel(idx+1, nums, num[1], width-num[0], width);

        return dp[idx][rem] = Math.min(a, b);
    }

    public int minHeightShelves(int[][] books, int width) {
        dp = new int[books.length+1][width+1];
        return travel(0, books, 0, width, width);
    }
}