class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double ans = 0;
        int i = discounts.length-1;
        int j = prices.length-1;

        while(i>=0 && j>=0){
            ans += (double)(prices[j--]*(100-discounts[i--]))/100.0;
        }

        while(j >= 0) ans += (double)(prices[j--]);

        return ans;
    }
}