class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.add(0);
        
        for(char ch: s.toCharArray()){
            if(ch == '('){
                st.add(0);
            }
            else{
                int val = st.pop();

                if(val == 0){
                    val = 1;
                }
                else{
                    val = val*2;
                }    

                st.add(st.pop() + val);  
            }
        }

        return st.peek();
    }
}