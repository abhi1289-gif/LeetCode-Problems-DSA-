class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int temp = 0;

        for(int g: gain){
            temp += g;
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}