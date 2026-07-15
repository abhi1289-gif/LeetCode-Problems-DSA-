class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int i = 1;
        int ans = 0;

        while(i < nums.length-1){
            int j = i;
            while(j < nums.length-1 && nums[j] - nums[j-1] == nums[j+1] - nums[j]){
                j++;
            }
            if(j > i){
                int num = j+1 - (i-1);
                ans += (num-1)*(num-2)/2;
            }

            i = j+1;
        }

        return ans;
    }
}