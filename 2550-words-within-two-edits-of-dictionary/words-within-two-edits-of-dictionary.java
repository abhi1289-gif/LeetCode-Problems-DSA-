class Solution {

    public class Trie {
        char ch;
        HashMap<Character, Trie> mapp = new HashMap<>();

        Trie(char ch) {
            this.ch = ch;
        }
    }

    Trie root = new Trie('0');

    public boolean isPossible(String s, int idx, int count, Trie temp){
        if(count < 0) return false;
        if(idx == s.length()){
            return count >= 0;
        }

        for(char key: temp.mapp.keySet()){
            if(key == s.charAt(idx)){
                if(isPossible(s, idx+1, count, temp.mapp.get(key))) return true;
            }
            else{
                if(isPossible(s, idx+1, count-1, temp.mapp.get(key))) return true;
            }
        }

        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        for(String s: dictionary){
            Trie temp = root;

            for(char ch: s.toCharArray()){

                if(!temp.mapp.containsKey(ch)){
                    Trie a = new Trie(ch);
                    temp.mapp.put(ch, a);
                }

                temp = temp.mapp.get(ch);
            }
        }

        List<String> ans = new ArrayList<>();

        for(String s: queries){
            if(isPossible(s, 0, 2, root)) ans.add(s);
        }

        return ans;
    }
}