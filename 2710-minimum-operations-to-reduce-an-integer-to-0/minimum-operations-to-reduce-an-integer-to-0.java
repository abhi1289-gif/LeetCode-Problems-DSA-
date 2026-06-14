class Solution {
    public int minOperations(int n) {
        int ans = 0;

        for(int i=0; i<17; i++){
            if(Integer.bitCount(n+(1<<i)) < Integer.bitCount(n)){
                n += (1<<i);
                ans++;
            }
        }
        return ans + Integer.bitCount(n);
    }
}