class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int j = 0;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int maxx = 0;
        int num = nums[0];
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);

            while(mapp.get(nums[i]) > k){
                mapp.put(nums[j], mapp.get(nums[j])-1);
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}