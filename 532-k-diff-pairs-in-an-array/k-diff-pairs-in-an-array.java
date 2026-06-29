class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;

        for(int key: mapp.keySet()){
            if(k == 0){
                if(mapp.get(key) > 1) ans++;
            }
            else{
                if(mapp.containsKey(k+key)) ans++;
            }
        }

        return ans;
    }
}