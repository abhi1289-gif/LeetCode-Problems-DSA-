class Solution {

    public int travel(int nums[], int mid){
        int ans = 0;
        for(int num: nums){
            if(num%mid == 0){
                ans += num/mid;
            }
            else{
                ans += num/mid+1;
            }
        }
        return ans;      
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            minn = Math.min(minn, nums[i]);
            maxx = Math.max(maxx, nums[i]);
        }

        if(threshold == nums.length) return maxx;

        int i = 1;
        int j = maxx;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            int a = travel(nums, mid);

            if(a <= threshold){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }

        return ans;
    }
}