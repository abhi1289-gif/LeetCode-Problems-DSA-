class Solution {
    public int minSwaps(String s) {
        StringBuilder str = new StringBuilder(s);
        int j = s.length()-1;
        int l = 0;
        int r = 0;
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            if(str.charAt(i) == '[') l++;
            else r++;

            if(l < r){
                while(j > i && str.charAt(j) != '[') j--;
                str.setCharAt(i, '[');
                str.setCharAt(j, ']');
                ans++;
                r--;
                l++;
            } 
        }
        return ans;
    }
}