class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int minn = nums[0];
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            while(minn != nums[i]){
                ans.add(minn);
                minn++;
            }
            i++;
            minn++;
        }
        return ans;
    }
}