class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int j = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);

            while(mapp.size() > 2){
                mapp.put(nums[j], mapp.get(nums[j])-1);
                if(mapp.get(nums[j]) == 0) mapp.remove(nums[j]);
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}