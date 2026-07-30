class Solution {
    public int minimumPushes(String word) {
        int a = 1;
        int b = 0;
        int i = word.length()-1;
        int ans = 0;
        while(i>=0){
            ans += a;
            b++;
            i--;
            if(b == 8){
                b = 0;
                a++;
            }
        }
        return ans;
    }
}