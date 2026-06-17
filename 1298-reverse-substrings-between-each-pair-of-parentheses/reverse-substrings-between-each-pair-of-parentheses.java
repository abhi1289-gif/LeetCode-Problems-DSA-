class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        st.push(new StringBuilder());

        for(char ch: s.toCharArray()){
            if(ch == '('){
                st.add(new StringBuilder());
            }
            else if(ch == ')'){
                StringBuilder curr = st.pop();
                curr.reverse();
                st.peek().append(curr);
            }
            else{
                st.peek().append(ch);
            }
        }
        return st.peek().toString();
    }
}