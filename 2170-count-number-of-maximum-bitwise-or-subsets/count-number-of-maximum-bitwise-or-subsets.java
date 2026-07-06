class Solution {

    int ans = 0;

    public void travel(int nums[], int pro, int num, int idx, int maxx){
        if(idx == nums.length){
            if(pro == maxx && num > 0) ans++;
            return;
        }

        // take
        travel(nums, pro|nums[idx], num+1, idx+1, maxx);

        // skip
        travel(nums, pro, num, idx+1, maxx);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxx = nums[0];

        for(int i=1; i<nums.length; i++) maxx = maxx | nums[i];

        ans = 0;

        travel(nums, 0, 0, 0, maxx);

        return ans;
    }
}