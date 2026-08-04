class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int minn = nums[0];
        int maxx = nums[0];

        for(int num: nums){
            maxx = Math.max(maxx, num);
            minn = Math.min(minn, num);
        }

        if(maxx-minn <= 2*k) return 0;
        return maxx-minn-2*k;
    }
}