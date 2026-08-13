class Solution {
    public long maximumOr(int[] nums, int k) {

        long left[] = new long[nums.length];
        long right[] = new long[nums.length];

        for(int i=1; i<nums.length; i++){
            left[i] = nums[i-1] | left[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            right[i] = nums[i+1] | right[i+1];
        }

        long maxx = 0;

        for(int i=0; i<nums.length; i++){
            long temp = nums[i]*(long)Math.pow(2, k);
            maxx = Math.max(maxx, left[i] | right[i] | temp);
        }

        return maxx;
    }
}