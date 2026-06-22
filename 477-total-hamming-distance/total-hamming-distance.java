class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int num = nums[i]^nums[j];
                ans += Integer.bitCount(num);
            }
        }

        return ans;
    }
}