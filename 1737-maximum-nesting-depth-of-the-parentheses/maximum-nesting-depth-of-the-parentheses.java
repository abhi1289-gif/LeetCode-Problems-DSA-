class Solution {
    public int maxDepth(String s) {
        int a = 0;
        int ans = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(') a++;
            else if(ch == ')') a--;
            ans = Math.max(ans, a);
        }
        return ans;
    }
}