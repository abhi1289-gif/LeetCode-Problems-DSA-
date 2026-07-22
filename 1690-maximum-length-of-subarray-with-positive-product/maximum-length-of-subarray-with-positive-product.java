class Solution {
    public int getMaxLen(int[] nums) {
        int pre = 1;
        int suf = 1;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            if(pre == 0){
                start = i;
                pre = 1;
            }

            if(suf == 0){
                end = i;
                suf = 1;
            }

            if(pre < 0) pre = -1;
            else pre = 1;

            if(suf < 0) suf = -1;
            else suf = 1;

            pre *= nums[i];
            suf *= nums[n-i-1];

            if(pre > 0) ans = Math.max(ans, i-start+1);

            if(suf > 0) ans = Math.max(ans, i-end+1);
        }

        return ans;
    }
}