class Solution {

    public class Trie{
        char ch;
        HashMap<Character, Trie> mapp = new HashMap<>();

        Trie(char ch){
            this.ch = ch;
            mapp.clear();
        }
    }

    HashMap<Trie, Integer> siz = new HashMap<>();

    Trie root = new Trie('0');

    public int minimumLengthEncoding(String[] words) {
        for(String word: words){
            Trie temp = root;

            for(int i=word.length()-1; i>=0; i--){
                char ch = word.charAt(i);

                if(!temp.mapp.containsKey(ch)){
                    Trie a = new Trie(ch);
                    temp.mapp.put(ch, a);
                }

                temp = temp.mapp.get(ch);

                if(siz.containsKey(temp)) siz.remove(temp);
            }

            if (temp.mapp.isEmpty()) {
                siz.put(temp, word.length());
            }
        }

        int ans = 0;

        for(int values: siz.values()) ans += values+1;

        return ans;
    }   

}