class Solution {

    int mod = 1000000007;
    int ans = 0;
    int dp[][];

    public int make(int idx, int sum, int target, List<Integer> nums){
        if(sum == target){
            return 1;
        }
        if(sum > target || idx >= nums.size()) return 0;

        if(dp[idx][sum] != -1) return dp[idx][sum];

        int a = make(idx+1, sum, target, nums);
        int b = make(idx+1, sum+nums.get(idx), target, nums);

        return dp[idx][sum] = (a%mod+b%mod)%mod;
    }

    public int numberOfWays(int n, int x) {
        List<Integer> nums = new ArrayList<>();
        int t = 1;

        while(true){
            int a = (int)Math.pow(t, x);
            if(a > n) break;
            nums.add(a);
            t++;
        }

        dp = new int[nums.size()][n+1];
        for(int i=0; i<nums.size(); i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }

        return make(0, 0, n, nums);
    }
}