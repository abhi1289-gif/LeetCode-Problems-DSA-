class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length-1;
        int idx = -1;
        while(j>0){
            if(nums[j-1] >= nums[j]) j--;
            else{
                idx = j;
                break;
            }
        }
        
        if(idx == -1){
            for(int i=0; i<nums.length/2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length-i-1];
                nums[nums.length-i-1] = temp;
            }
            return;
        }

        int k = nums.length - 1;

        while(nums[k] <= nums[idx - 1]){
            k--;
        }

        int temp = nums[k];
        nums[k] = nums[idx-1];
        nums[idx-1] = temp;
        Arrays.sort(nums, idx, nums.length);
    }
}