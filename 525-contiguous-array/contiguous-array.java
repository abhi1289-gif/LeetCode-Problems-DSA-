class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int ans = 0;
        int sum = 0;
        mapp.put(0, -1);
        for(int i=0; i<n; i++){
            sum += (nums[i] == 1)? 1: -1;

            if(mapp.containsKey(sum)){
                ans = Math.max(ans, i-mapp.get(sum));
            }
            else{
                mapp.put(sum, i);
            }
        }

        return ans;

    }
}