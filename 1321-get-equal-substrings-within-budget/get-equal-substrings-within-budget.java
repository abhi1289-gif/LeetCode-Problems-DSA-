class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int j = 0;
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            int cost = Math.abs((int)(s.charAt(i)-t.charAt(i)));
            maxCost -= cost;

            while(maxCost < 0){
                int temp = Math.abs((int)(s.charAt(j)-t.charAt(j)));
                j++;
                maxCost += temp;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}