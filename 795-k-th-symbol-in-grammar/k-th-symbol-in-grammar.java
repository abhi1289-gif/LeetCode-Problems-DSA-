class Solution {
    public int kthGrammar(int n, int k) {
        int ans = 0;
        int flip = 0;
        while (n > 1) {
            int half = (int)Math.pow(2, n - 2);

            if (k > half) {
                flip++;
                k -= half;
            }

            n--;
        }

        return (flip % 2 == 0) ? 0 : 1;
    }
}