class Solution {

    HashSet<String> ans;
    int maxx;

    public void travel(int i, String s, StringBuilder temp, int opn){
        if(i == s.length()){
            if(opn != 0) return;

            if(maxx < temp.length()){
                ans.clear();
                ans.add(temp.toString());
                maxx = temp.length();
            }
            else if(maxx == temp.length()){
                ans.add(temp.toString());
            }

            return;
        }

        if(s.charAt(i) == '('){
            travel(i+1, s, temp, opn);
            temp.append('(');
            travel(i+1, s, temp, opn+1);
            temp.deleteCharAt(temp.length() - 1);
        }
        else if(s.charAt(i) == ')'){
            travel(i+1, s, temp, opn);
            if(opn <= 0) return;
            temp.append(')');
            travel(i+1, s, temp, opn-1);
            temp.deleteCharAt(temp.length() - 1);
        }
        else{
            temp.append(s.charAt(i));
            travel(i+1, s, temp, opn);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        maxx = 0;
        StringBuilder sb = new StringBuilder();
        travel(0, s, sb, 0);
        if(ans.size() == 0) ans.add("");
        return new ArrayList<>(ans);
    }
}