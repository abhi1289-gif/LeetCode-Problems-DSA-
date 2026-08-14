class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> mapp = new HashMap<>();
        int j = 0;
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);

            while(mapp.get(ch) > 2){
                char temp = s.charAt(j);
                mapp.put(temp, mapp.get(temp)-1);
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}