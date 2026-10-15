class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for(int i=0; i<nums.size(); i++){
            HashSet<Integer> mapp = new HashSet<>();
            for(int j=i; j<nums.size(); j++){
                mapp.add(nums.get(j));
                ans += Math.pow(mapp.size(), 2);
            }
        }
        return ans;
    }
}