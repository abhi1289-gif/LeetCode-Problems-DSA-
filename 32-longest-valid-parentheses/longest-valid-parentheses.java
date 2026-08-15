class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.add(-1);

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') st.add(i);
            else{
                st.pop();
                if(st.size() == 0) st.add(i);
                else ans = Math.max(ans, i-st.peek());
            }
        }
        return ans;
    }
}