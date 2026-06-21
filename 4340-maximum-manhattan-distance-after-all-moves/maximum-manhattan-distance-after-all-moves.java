class Solution {
    public int maxDistance(String moves) {
        int ans = 0;
        int x = 0;
        int y = 0;
        int d = 0;

        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == '_'){
                d++;
                continue;
            }
            if(ch == 'U') y++;
            else if(ch == 'D') y--;
            else if(ch == 'L') x--;
            else x++;
        }

        ans = Math.abs(x) + Math.abs(y);

        return ans+d;
    }
}