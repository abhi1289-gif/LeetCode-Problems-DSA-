class Solution {
    public int countCollisions(String s) {
        int ans = 0;
        int l = 0;
        int r = s.length()-1;

        while(l < s.length() && s.charAt(l) == 'L') l++;
        while(r >= 0 && s.charAt(r) == 'R') r--;

        for(int i=l; i<=r; i++){
            if(s.charAt(i) != 'S') ans++;
        }

        return ans;
    }
}