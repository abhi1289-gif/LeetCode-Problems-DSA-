class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        if(n%2 == 0){
            if(m%2 == 0) return 0;
            else{
                int ans = 0;
                for(int num: nums1) ans = ans^num;
                return ans;
            }
        }
        else{
            if(m%2 == 0){
                int ans = 0;
                for(int num: nums2) ans = ans^num;
                return ans;
            }
            else{
                int ans = 0;
                for(int num: nums1) ans = ans^num;
                for(int num: nums2) ans = ans^num;
                return ans;
            }
        }
    }
}