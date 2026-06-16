class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);

            while(st.size() > 0 && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }

            st.add(ch);
        }

        if(k > 0){
            while(st.size() > 0 && k > 0){
                st.pop();
                k--;
            }
        }

        StringBuilder s = new StringBuilder();

        while(st.size() > 0){
            s.append(st.pop());
        }
        while(s.length() > 0 && s.charAt(s.length()-1) == '0') s.deleteCharAt(s.length()-1);
        s.reverse();

        String ans = s.toString();

        return ans.isEmpty() ? "0" : ans;
    }
}