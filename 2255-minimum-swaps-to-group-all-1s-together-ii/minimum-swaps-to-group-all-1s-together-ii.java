class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for(int num: nums) if(num == 1) ones++;

        int arr[] = new int[nums.length*2];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
        }

        int zeros = 0;
        for(int i=0; i<ones; i++) if(nums[i] == 0) zeros++;

        int ans = zeros;

        for(int i=ones; i<arr.length; i++){
            if(arr[i] == 0) zeros++;
            if(arr[i-ones] == 0) zeros--;
            ans = Math.min(zeros, ans);
        }

        return ans;
    }
}