class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int j = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);

            while(mapp.get(nums[i]) > 1){
                mapp.put(nums[j], mapp.get(nums[j])-1);
                sum -= nums[j];
                j++;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}