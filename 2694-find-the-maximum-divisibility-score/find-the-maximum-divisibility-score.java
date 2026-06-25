class Solution {
    public int maxDivScore(int[] nums, int[] arr) {
        int ans = -1;
        int maxx = -1;
        int n = nums.length;
        int m = arr.length;

        for(int i=0; i<m; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                if(nums[j]%arr[i]==0) temp++;
            }
            if(maxx < temp){
                maxx = temp;
                ans = arr[i];
            }
            else if(maxx == temp && ans > arr[i]){
                ans = arr[i];
            }
        }
        return ans;
    }
}