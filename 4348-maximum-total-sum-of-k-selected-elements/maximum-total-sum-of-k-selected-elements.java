class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        long ans = 0;
        int i = 0;

        while(k > 0){
            k--;
            if(mul > 0){
                ans += (long)nums[i]*mul;
                mul--;
            }
            else{
                ans += nums[i];
            }
            i++;
        }
        return ans;
    }
}