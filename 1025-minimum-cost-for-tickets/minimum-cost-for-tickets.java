class Solution {

    int dp[][];

    public int travel(int days[], int idx, int costs[], int upto){
        if(idx >= days.length){
            return 0;
        }

        if(upto >=0 && dp[idx][upto] != -1) return dp[idx][upto];

        int ans = 0;

        if(upto > days[idx]){
            ans = travel(days, idx+1, costs, upto);
        }
        else{
            int a = costs[0] + travel(days, idx+1, costs, days[idx]);
            int b = costs[1] + travel(days, idx+1, costs, days[idx] + 7);
            int c = costs[2] + travel(days, idx+1, costs, days[idx] + 30);
            ans = Math.min(a, Math.min(b, c));
        }

        if (upto >= 0) {
            dp[idx][upto] = ans;
        }

        return ans;
    }

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length+1][400];

        for(int i=0; i<=days.length; i++){
            for(int j=0; j<400; j++){
                dp[i][j] = -1;
            }
        }
        return travel(days, 0, costs, -1);
    }
}