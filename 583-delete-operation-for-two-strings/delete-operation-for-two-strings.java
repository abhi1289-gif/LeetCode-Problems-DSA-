class Solution {
    
    int dp[][];

    public int travel(String a, String b, int ia, int ib){
        if(ia == a.length() || ib == b.length()){
            if(ia == a.length()){
                return b.length() - ib;
            }
            else{
                return a.length() - ia;
            }
        }

        if(dp[ia][ib] != -1) return dp[ia][ib];

        int res = -1;

        if(a.charAt(ia) == b.charAt(ib)) res = travel(a, b, ia+1, ib+1);
        else{
            int temp1 = 1 + travel(a, b, ia, ib+1);
            int temp2 = 1 + travel(a, b, ia+1, ib);
            res = Math.min(temp1, temp2);
        }

        return dp[ia][ib] = res;
    }

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++){
            for(int j=0; j<=word2.length(); j++) dp[i][j] = -1;
        }
        return travel(word1, word2, 0, 0);
    }
}