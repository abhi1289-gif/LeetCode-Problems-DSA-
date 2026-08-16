class Solution {
    public boolean stoneGameIX(int[] stones) {
        int nums[] = new int[3];

        for(int x : stones){
            nums[x % 3]++;
        }

        if(nums[1] == 0 || nums[2] == 0){
            return Math.max(nums[1], nums[2]) > 2 && nums[0] % 2 == 1;
        }

        return nums[0] % 2 == 0 || Math.abs(nums[1] - nums[2]) > 2;
    }
}