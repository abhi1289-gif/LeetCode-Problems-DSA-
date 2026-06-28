class Solution {

    public String make(StringBuilder s){
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            ans.append((char)('a' + (ch - 'a' + 1) % 26));
        }

        return ans.toString();
    }

    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");

        while(s.length() <= k){
            s.append(make(s));
        }

        return s.charAt(k-1);
    }
}