class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int a = 1;
        int b = 1;
        int ans = 1;

        for(int i=1; i<nums1.length; i++){
            int na = 1;
            int nb = 1;

            if(nums1[i] >= nums1[i-1]){
                na = Math.max(na, a+1);
            }
            if(nums1[i] >= nums2[i-1]){
                na = Math.max(na, b+1);
            }
            if(nums2[i] >= nums2[i-1]){
                nb = Math.max(nb, b+1);
            }
            if(nums2[i] >= nums1[i-1]){
                nb = Math.max(nb, a+1);
            }

            a = na;
            b = nb;

            ans = Math.max(ans, Math.max(a, b));
        }

        return ans;
    }
}