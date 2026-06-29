class Solution {
    public String reverseStr(String s, int k) {
        int i = 0;

        StringBuilder ans = new StringBuilder();
        
        while(i + k < s.length()){
            StringBuilder temp = new StringBuilder(s.substring(i, i+k));
            temp.reverse();
            ans.append(temp);
            i += k;
            ans.append(s.substring(i, Math.min(s.length(), i+k)));
            i += k;
        }

        if(i < s.length()){
            StringBuilder temp = new StringBuilder(s.substring(i, s.length()));
            temp.reverse();
            ans.append(temp);
        }
        
        return ans.toString();
    }
}