class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;

        for(int i=0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        for(int i=nums.length-1; i>=nums.length/2; i--){
            ans += (long)nums[i]*nums[i];
        }

        for(int i=0; i<nums.length/2; i++){
            ans -= (long)nums[i]*nums[i];
        }

        return ans;
    }
}