class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;

        int j=0;
        int i=0;
        int temp=0;
        char tmp = '#';

        while(j<t.length() && i<s.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                if(temp==0){
                    temp=1;
                    tmp = s.charAt(i);
                    i++;
                    j++;
                }else{
                    while(j < t.length() && s.charAt(i) != t.charAt(j)){
                        if(t.charAt(j) == tmp){
                            temp=0;
                            j++;
                            break;
                        }else j++;
                    }
                }
            }
        }
        if(i>=s.length()) return true;
        return false;
    }
}