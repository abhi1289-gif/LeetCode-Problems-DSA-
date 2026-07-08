class Solution {

    Boolean dp[][];

    public boolean travel(int i, int j, String s, String t, String r){
        if(i == s.length() && j == t.length()) return true;

        if(dp[i][j] != null) return dp[i][j];

        boolean first = false;
        boolean second = false;

        if(i<s.length() && s.charAt(i) == r.charAt(i+j)) first = travel(i+1, j, s, t, r);

        if(j < t.length() && t.charAt(j) == r.charAt(i+j)) second = travel(i, j+1, s, t, r);

        return dp[i][j] = first || second;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        dp = new Boolean[s1.length()+1][s2.length()+1];

        return travel(0, 0, s1, s2, s3);
    }
}