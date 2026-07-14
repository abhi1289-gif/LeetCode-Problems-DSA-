class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int n = profit.length;
        int nums[][] = new int[n][2];

        for(int i=0; i<n; i++){
            nums[i][0] = difficulty[i];
            nums[i][1] = profit[i];
        }

        Arrays.sort(nums, (a, b)-> a[0]-b[0]);

        for(int i=1; i<n; i++){
            nums[i][1] = Math.max(nums[i][1], nums[i-1][1]);
        }

        

        for(int k=0; k<worker.length; k++){
            int num = worker[k];
            int i = 0;
            int j = n-1;
            int temp = -1;

            while(i<=j){
                int mid = i + (j-i)/2;

                if(nums[mid][0]<=num){
                    temp = mid;
                    i = mid+1;
                }
                else{
                    j = mid-1;
                }
            }

            if(temp != -1) ans += nums[temp][1];
        }

        return ans;
    }
}