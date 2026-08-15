class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = low;
        while(mid <= high){
            if(nums[mid] == 1) mid++;
            else if(nums[mid] == 0){
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            }
            else{
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }
}