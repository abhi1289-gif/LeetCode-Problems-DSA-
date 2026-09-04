class Solution {
    public int secondsToRemoveOccurrences(String a) {
        StringBuilder s = new StringBuilder(a);
        int ans = 0;
        while(true){
            boolean canBreak = true;
            for(int i=0; i<s.length()-1; i++){
                if(s.charAt(i) == '0' && s.charAt(i+1) == '1'){
                    s.setCharAt(i, '1');
                    s.setCharAt(i+1, '0');
                    canBreak = false;
                    
                    i++;
                }
            }
            if(canBreak) break;
            ans++;
        }
            
        return ans;
    }
}