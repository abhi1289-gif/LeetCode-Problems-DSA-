class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxx = nums[0];
        for(int num: nums) maxx = Math.max(maxx, num);
        long ans = 0;
        int count = 0;
        int j = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == maxx) count++;

            while(count >= k){
                ans += (long) nums.length - i;
                if(nums[j] == maxx) count--;
                j++;
            }
        }

        return ans;
    }
}