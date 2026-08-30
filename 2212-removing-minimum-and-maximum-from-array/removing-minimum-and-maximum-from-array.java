class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length < 3) return nums.length;
        int minn = nums[0];
        int maxx = nums[0];
        int mini = 0;
        int maxi = 0;
        int n = nums.length;

        for(int i=1; i<n; i++){
            if(nums[i] > maxx){
                maxx = nums[i];
                maxi = i;
            }

            if(nums[i] < minn){
                minn = nums[i];
                mini = i;
            }
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if(mini < maxi){
            a = maxi + 1;
            b = mini + 1 + (n - maxi);
            c = n - mini;
        }
        else{
            a = mini + 1;
            b = maxi + 1 + (n - mini);
            c = n - maxi;
        }

        return Math.min(a, Math.min(b, c));
        
    }
}