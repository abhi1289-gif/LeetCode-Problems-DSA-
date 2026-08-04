class Solution {
    public int minMoves(int[] nums) {
        int maxx = nums[0];
        for(int num: nums) maxx = Math.max(maxx, num);
        int ans = 0;
        for(int num: nums) ans += maxx-num;
        return ans;
    }
}