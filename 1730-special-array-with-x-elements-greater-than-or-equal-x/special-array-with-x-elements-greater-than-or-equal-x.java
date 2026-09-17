class Solution {
    public int specialArray(int[] nums) {
        for(int i=0; i<=nums.length; i++){
            int temp = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] >= i) temp++;
            }
            if(temp == i) return i;
        }
        return -1;
    }
}