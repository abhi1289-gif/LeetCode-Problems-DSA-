class Solution {

    public boolean travel(int nums[], int i, int j, int a, int b, int turn){
        if (i > j) return a >= b;

        if(turn == 1){
            return travel(nums, i+1, j, a+nums[i], b, 0) || travel(nums, i, j-1, a+nums[j], b, 0);
        }
        else return travel(nums, i+1, j, a, b+nums[i], 1) && travel(nums, i, j-1, a, b+nums[j], 1);
    }

    public boolean predictTheWinner(int[] nums) {
        return travel(nums, 0, nums.length-1, 0, 0, 1);
    }
}