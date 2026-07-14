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

        for(int i=0; i<worker.length; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                if(nums[j][0] > worker[i]) break;
                temp = Math.max(temp, nums[j][1]);
            }
            ans += temp;
        }

        return ans;
    }
}