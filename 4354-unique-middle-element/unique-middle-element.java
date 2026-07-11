class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int num = nums[nums.length/2];
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == num){
                if(count == 1) return false;
                count ++;
            }
        }

        return true;

    }
}