class Solution {
    
    int mod = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Long> nums = new ArrayList<>();
        long temp = 1;
        while(temp <= n){
            if((n & temp) != 0){
                nums.add(temp);
            }

            temp *= 2;
        }
        int ans[] = new int[queries.length];

        int i = 0;

        for(int qu[]: queries){
            int l = qu[0];
            int r = qu[1];

            long product = 1;

            for(int j = l; j <= r; j++){
                product = (product * nums.get(j)) % mod;
            }

            ans[i] = (int) product;
            i++;
        }

        return ans;
    }
}