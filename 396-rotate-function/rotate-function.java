class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;

        int temp = 0;
        for(int i=0; i<nums.length; i++) temp += nums[i]*i;

        int ans = temp;

        for(int i=nums.length-1; i>=1; i--){
            temp += sum - nums.length*nums[i];
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}