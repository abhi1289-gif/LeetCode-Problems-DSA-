class Solution {
    public int hIndex(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int ans = 0;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums[mid]< nums.length-mid){
                i = mid+1;
            }
            else{
                ans = nums.length-mid;
                j = mid-1;
            }
        }
        
        return ans;
    }
}