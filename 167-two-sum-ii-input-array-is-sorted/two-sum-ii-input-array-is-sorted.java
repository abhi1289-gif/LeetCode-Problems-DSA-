class Solution {
    public int[] twoSum(int[] nums, int t) {
        int i = 0;
        int j = nums.length-1;
        int sum = nums[i] + nums[j];

        while(i < j){
            if(sum > t){
                sum -= nums[j--];
                sum += nums[j];
            }
            else if(sum < t){
                sum -= nums[i++];
                sum += nums[i];
            }
            else return new int[]{i+1, j+1};
        }
        return new int[]{-1, -1};
    }
}