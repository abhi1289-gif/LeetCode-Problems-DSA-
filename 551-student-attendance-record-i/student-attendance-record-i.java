class Solution {
    public boolean checkRecord(String s) {

        if(s.length() < 3){
            if(s.length() == 1) return true;
            if(s.charAt(0) == 'A' && s.charAt(1) == 'A') return false;
            return true;
        }

        int a = 0;

        if(s.charAt(0) == 'A') a++;
        if(s.charAt(s.length()-1) == 'A') a++;

        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i-1) == 'L' && s.charAt(i) == 'L' && s.charAt(i+1) == 'L') return false;
            if(s.charAt(i) == 'A') a++;
        }
        if(a > 1) return false;
        return true;
    }
}