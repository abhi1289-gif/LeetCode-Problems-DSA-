class Solution {

    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    public int gcdOfOddEvenSums(int n) {
        int a = n*n;
        int b = n*(n+1);

        return gcd(a, b);
    }
}