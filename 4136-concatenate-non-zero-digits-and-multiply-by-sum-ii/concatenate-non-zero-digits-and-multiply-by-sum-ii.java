class Solution {

    long mod = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int sum[] = new int[s.length()+1];  
        long prefixVal[] = new long[s.length()+1];
        int nonZero[] = new int[s.length()+1];

        int temp = 0;

        long[] pow10 = new long[s.length()+1];

        pow10[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }


        for(int i=1; i<=s.length(); i++){
            int digit = s.charAt(i - 1) - '0';
            sum[i] = sum[i - 1] + digit;

            nonZero[i] = nonZero[i-1];
            prefixVal[i] = prefixVal[i - 1];

            if(s.charAt(i-1) != '0'){
                nonZero[i] = nonZero[i-1]+1;

                prefixVal[i] = (prefixVal[i-1]*10 + digit)%mod;
            }

        }

        int ans[] = new int[queries.length];

        int a = 0;

        for(int qu[]: queries){
            int l = qu[0];
            int r = qu[1];

            long digSum = sum[r+1] - sum[l];

            int count = nonZero[r+1] - nonZero[l];

            long x = (prefixVal[r + 1] - prefixVal[l] * pow10[count] % mod + mod) % mod;

            ans[a++] = (int) (x * (digSum % mod) % mod);
        }

        return ans;
    }
}