class Solution {

    int dp[][];

    public int solve(int i, int j, String a, String b){
        if(i == a.length() || j == b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = 1 + solve(i+1, j+1, a, b);
        }
        else{
            int takeb = solve(i+1, j, a, b);
            int takea = solve(i, j+1, a, b);

            return dp[i][j] = Math.max(takea, takeb);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, text1, text2);
    }
}