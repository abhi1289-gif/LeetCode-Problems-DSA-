class Solution {
    public int removeCoveredIntervals(int[][] nums) {
        int n = nums.length;
        int ans = n;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(nums[j][0] <= nums[i][0] && nums[i][1] <= nums[j][1]){
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}