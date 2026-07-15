class Solution {

    int dp[][];

    public int travel(int nums[][], int idx, int maxx){
        if(idx == nums.length){
            return 0;
        }

        if(maxx != Integer.MIN_VALUE){
            if(dp[idx][maxx+1000] != -1) return dp[idx][maxx+1000];
        }

        int a = 0;

        if(nums[idx][0] > maxx){
            a = 1 + travel(nums, idx+1, nums[idx][1]);
        }

        int b = travel(nums, idx+1, maxx);

        int ans = Math.max(a, b);

        if(maxx != Integer.MIN_VALUE){
            dp[idx][maxx+1000] = ans;
        }

        return ans;
        
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)-> a[0]-b[0]);
        dp = new int[pairs.length+1][2002];
        for(int i=0; i<pairs.length+1; i++){
            for(int j=0; j<2002; j++){
                dp[i][j] = -1;
            }
        }
        return travel(pairs, 0, Integer.MIN_VALUE);
    }
}