class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }

        int maxx = nums[0];
        for(int num: nums){
            maxx = Math.max(num, maxx);
        }

        int n = 0;
        int msb = 1;
        while (maxx > 1) {
            maxx /= 2;
            msb *= 2;
        }

        return msb*2;
    }
}