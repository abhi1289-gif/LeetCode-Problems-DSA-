class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int z = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
            else{
                z++;
            }
        }

        i = nums.length-1;
        while(z > 0 && i >= 0){
            nums[i--] = 0;
            z--;
        }

    }
}