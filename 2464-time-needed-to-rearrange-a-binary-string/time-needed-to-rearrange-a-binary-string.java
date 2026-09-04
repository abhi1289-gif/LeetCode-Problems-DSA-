class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        int z = 0;
        if(s.charAt(0) == '0') z = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                z++;
            } 
            else{
                if(z > 0){
                    ans = Math.max(ans + 1, z);
                }
            }
        }
        
        return ans;
    }
}