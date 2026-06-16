class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '*'){
                if(ans.length() == 0) continue;
                ans.deleteCharAt(ans.length()-1);
            }
            else if(ch == '#'){
                ans.append(ans);
            }
            else if(ch == '%'){
                ans.reverse();
            }
            else{
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}