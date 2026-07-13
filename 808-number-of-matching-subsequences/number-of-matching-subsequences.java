class Solution {

    public boolean travel(String s, String num){
        int i = 0;
        int j = 0;

        while(i < s.length() && j < num.length()){
            if(s.charAt(i) == num.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }

        return j == num.length();
    }

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;

        HashMap<String, Boolean> mapp = new HashMap<>();

        for(String word: words){
            if(!mapp.containsKey(word)){
                mapp.put(word, travel(s, word));
            }

            if(mapp.get(word)) ans++;
        }

        return ans;
    }
}