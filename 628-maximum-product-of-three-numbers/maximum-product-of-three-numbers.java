class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        ans = Math.max(ans, nums[n-1]*nums[n-2]*nums[n-3]);
        ans = Math.max(ans, nums[0]*nums[1]*nums[n-1]);

        return ans;
    }
}