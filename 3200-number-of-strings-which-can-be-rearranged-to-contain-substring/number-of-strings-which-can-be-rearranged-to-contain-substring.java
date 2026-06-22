class Solution {

    long dp[][][][];
    int mod = 1000000007;

    public long travel(int idx, int l, int e, int t, int n){
        if(idx == n){
            if(l >= 1 && e >= 2 && t >= 1){
                return 1;
            }
            return 0;
        }

        if(dp[idx][l][e][t] != -1) return dp[idx][l][e][t];

        long res = 0;

        for(char ch = 'a'; ch<='z'; ch++){
            if(ch == 'l'){
                res = (res + travel(idx+1, Math.min(l+1, 1), e, t, n))%mod;
            }
            else if(ch == 'e'){
                res = (res + travel(idx+1, l, Math.min(2, e+1), t, n))%mod;
            }
            else if(ch == 't'){
                res = (res + travel(idx+1, l, e, Math.min(1, t+1), n))%mod;
            }
            else{
                res = (res + travel(idx+1, l, e, t, n))%mod;
            }
        }

        return dp[idx][l][e][t] = res;
    }

    public int stringCount(int n) {
        dp = new long[n+1][2][3][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    for(int l=0; l<2; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return (int)travel(0, 0, 0, 0, n); 
    }
}