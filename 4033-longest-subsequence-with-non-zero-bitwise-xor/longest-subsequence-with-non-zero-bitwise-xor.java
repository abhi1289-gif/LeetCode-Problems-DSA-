class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0;
        for(int num: nums) x = x^num;
        if(x != 0) return nums.length;

        for(int num: nums){
            if(num != 0) return nums.length-1;
        }

        return 0;
    }

}