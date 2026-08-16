class Solution {
    public boolean stoneGameIX(int[] stones) {
        int nums[] = new int[3];

        for(int x : stones) nums[x % 3]++;

        if (nums[1] == 0 || nums[2] == 0) {

            int nonZero = Math.max(nums[1], nums[2]);

            if (nonZero > 2 && nums[0] % 2 == 1) {
                return true;
            }

            return false;
        }

        if (nums[0] % 2 == 0) {
            return true;
        }

        int difference = Math.abs(nums[1] - nums[2]);

        return difference > 2;
    }
}