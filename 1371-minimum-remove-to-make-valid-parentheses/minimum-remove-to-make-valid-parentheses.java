class Solution {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st= new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') st.add(i);
            else if(ch == ')'){
                if(st.size() == 0){
                    set.add(i);
                }
                else st.pop();
            }
        }

        while(st.size() > 0){
            set.add(st.pop());
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(set.contains(i)) continue;
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}