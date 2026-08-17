class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int brr[] = new int[n];

        int maxx = nums[0];
        arr[0] = -1;
        for(int i=1; i<n; i++){
            arr[i] = maxx;
            maxx = Math.max(nums[i], maxx);
        }

        maxx = nums[n-1];
        brr[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            brr[i] = maxx;
            maxx = Math.max(maxx, nums[i]);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            int temp = Math.min(arr[i], brr[i]) - nums[i];
            if(temp > 0) ans += temp;
        }
        return ans;
    }
}