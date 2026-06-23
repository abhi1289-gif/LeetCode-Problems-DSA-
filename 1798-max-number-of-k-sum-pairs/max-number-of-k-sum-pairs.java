class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int ans = 0;

        for(int num: nums){
            int rem = k-num;

            if(mapp.containsKey(rem)){
                if(mapp.get(rem) > 0){
                    ans++;
                    if(mapp.get(rem) - 1 == 0) mapp.remove(rem);
                    else mapp.put(rem, mapp.get(rem)-1);
                }
                else{
                    mapp.put(num, mapp.getOrDefault(num, 0)+1);
                }
            }
            else{
                mapp.put(num, mapp.getOrDefault(num, 0)+1);
            }
        }

        return ans;
    }
}