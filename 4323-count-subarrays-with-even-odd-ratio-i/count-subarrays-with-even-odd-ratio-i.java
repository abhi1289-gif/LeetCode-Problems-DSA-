class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int o = 0;
            int e = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2 == 0) e++;
                else o++;

                if(o>0 && (double)e/o <= (double)a/b) ans++;
            }
        }
        return ans;
    }
}