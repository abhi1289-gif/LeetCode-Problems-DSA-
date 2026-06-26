class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int ans[] = new int[2];
        
        for(int i=0; i<nums.length; i++){
            mapp.put(i+1, mapp.getOrDefault(i+1, 0)+1);
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);
        }
        for(int key: mapp.keySet()){
            if(mapp.get(key) == 1){
                ans[1] = key;
            }
            else if(mapp.get(key) == 3){
                ans[0] = key;
            }
        }
        return ans;
    }
}