class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mapp = new HashMap<>();
        for(char ch: s.toCharArray()){
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            if(mapp.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}