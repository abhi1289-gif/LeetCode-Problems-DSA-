class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = nums[n-1]-nums[0];

        for(int i=0; i<n-1; i++){
            int maxx = Math.max(nums[n-1]-k, nums[i]+k);
            int minn = Math.min(nums[0]+k, nums[i+1]-k);

            ans = Math.min(ans, maxx-minn);
        }
        return ans;
    }
}