class Solution {

    int ans;

    public void travel(long n, int count){
        if(n == 1){
            ans = Math.min(ans, count);
            return;
        }

        count++;

        if(n%2 == 0){
            travel(n/2, count);
        }
        else{
            travel(n+1, count);
            travel(n-1, count);
        }
    }

    public int integerReplacement(int n) {
        ans = Integer.MAX_VALUE;

        travel((long)n, 0);
        return ans;
    }
}