class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') st.add(ch);
            else{
                if(i+1 < s.length() && s.charAt(i+1) == ')'){
                    i++;
                }
                else{
                    ans++;
                }

                if(st.size() == 0){
                    ans++;
                }
                else{
                    st.pop();
                }
            }
        }

        return ans + 2*st.size();
    }
}