class Solution {

    public int minOperations(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        boolean breaked = false;
        int idx = -1;

        for(int i=nums.length-1; i>=0; i--){
            if(mapp.containsKey(nums[i])){
                breaked = true;
                idx =i;
                break;
            }
            mapp.put(nums[i], 0);
        }
        if(!breaked) return 0;
        return idx/3+1;
    }
}