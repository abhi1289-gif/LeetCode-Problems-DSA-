class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;

        long ans = 0;

        for(int i=0; i<nums.length; i++){
            minn = Math.min(minn, nums[i]);
            maxx = Math.max(maxx, nums[i]);
        }

        ans = (long)(maxx-minn);

        return ans*((long)(k));
    }
}