class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') st.add(i);
            else{
                if(st.size() == 1){
                    set.add(i);
                    set.add(st.peek());
                }
                st.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(set.contains(i)) continue;
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}