class Solution {
    public int countPrimes(int n) {
        // Sieve of Eratosthenes.
        boolean arr[] = new boolean[n+1];

        for(int i=0; i<n; i++) arr[i] = true;

        for(int i=2; i*i<n; i++){
            if(arr[i]){
                for(int j=i*i; j<n; j+=i){
                    arr[j] = false;
                }
            }
        }

        int ans = 0;

        for(int i=2; i<n; i++) if(arr[i]) ans++;

        return ans;
    }
}