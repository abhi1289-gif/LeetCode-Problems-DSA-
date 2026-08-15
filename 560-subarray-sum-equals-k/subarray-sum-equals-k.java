class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int i=1; i<nums.length; i++) nums[i] = nums[i] + nums[i-1];
        int ans = 0;
        mapp.put(0, 1);

        for(int i=0; i<nums.length; i++){
            if(mapp.containsKey(nums[i]-k)) ans += mapp.get(nums[i]-k);
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);
        }
        return ans;
    }
}