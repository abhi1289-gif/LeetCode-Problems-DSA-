class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(b.length() == 0) return 0;
        StringBuilder s = new StringBuilder();
        int ans = 0;

        while(s.length() < b.length()){
            ans++;
            s.append(a);
        }

        for(int i=0; i<=s.length()-b.length(); i++){
            if(s.charAt(i) == b.charAt(0)){
                if(s.substring(i, i + b.length()).equals(b)) return ans;
            }
        }

        s.append(a);
        ans++;

        for(int i=0; i<=s.length()-b.length(); i++){
            if(s.charAt(i) == b.charAt(0)){
                if(s.substring(i, i + b.length()).equals(b)) return ans;
            }
        }
        
        return -1;
    }
}