class Solution {

    int mod = 1000000007;

    public int distinctSubseqII(String s) {
        long dp[] = new long[s.length()+1];
        int nums[] = new int[26];

        dp[0] = 1;

        for(int i=1; i<=s.length(); i++){
            int a = (int)(s.charAt(i-1) -  'a');

            dp[i] = (2 * dp[i-1]) % mod;

            if(nums[a] != 0){
                dp[i] = ((dp[i] - dp[nums[a] - 1]) + mod)%mod;
            }

            nums[a] = i;
        }

        return (int)(dp[s.length()]-1 + mod)%mod;
    }
}