class Solution {

    int dp[];
    int mod = 1000000007;

    public int travel(int time, int n, int d, int forget){
        if(time > n) return 0;
        if(dp[time] != -1) return dp[time];

        int count = (time+forget > n) ? 1: 0;

        for(int i=time+d; i<=Math.min(n, time+forget-1); i++){
            count = (count + travel(i, n, d, forget))%mod;
        }

        return dp[time] = count;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        int ans = travel(1, n, delay, forget);
        return ans;
    }
}