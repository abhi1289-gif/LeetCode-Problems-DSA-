class Solution {

    Boolean dp[][];

    public boolean travel(int i, int lft, String s){
        if(i == s.length()){
            if(lft == 0) return true;
            return false;
        }

        if(dp[i][lft] != null) return dp[i][lft];

        if(s.charAt(i) == ')'){
            if(lft <= 0) return false;
            return dp[i][lft] = travel(i+1, lft-1, s);
        }

        if(s.charAt(i) == '('){
            return dp[i][lft] = travel(i+1, lft+1, s);
        }

        boolean a = false;
        boolean b = false;
        boolean c = false;

        if(lft > 0) a = travel(i+1, lft-1, s);

        return dp[i][lft] = a || travel(i+1, lft, s) || travel(i+1, lft+1, s);
    }

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()];
        return travel(0, 0, s);
    }
}