class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                int a = i;
                int b = j;
                int temp = 0;

                while(a < nums1.length && b < nums2.length && nums1[a] == nums2[b]){
                    a++;
                    b++;
                    temp++;
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}