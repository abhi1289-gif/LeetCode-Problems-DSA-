class Solution {

    Boolean dp[][][];

    public boolean travel(int nums[], int i, int j, int a, int b, int turn){
        if (i > j) return a > b;

        if(dp[i][j][turn] != null) return dp[i][j][turn];

        Boolean p = false;
        Boolean q = false;

        if(turn == 1){
            p= travel(nums, i+1, j, a+nums[i], b, 0) || travel(nums, i, j-1, a+nums[j], b, 0);
        }
        else q = travel(nums, i+1, j, a, b+nums[i], 1) || travel(nums, i, j-1, a, b+nums[j], 1);

        return dp[i][j][turn] = p || q;
    }

    public boolean stoneGame(int[] piles) {
        dp = new Boolean[piles.length][piles.length][2];
        return travel(piles, 0, piles.length-1, 0, 0, 1);
    }
}