class Solution {

    public class Trie{
        char val;
        boolean leaf;
        HashMap<Character, Trie> mapp = new HashMap<>();

        Trie(char val){
            this.val = val;
            mapp.clear();
            this.leaf = false;
        }
    }

    Trie root = new Trie('0');

    public String longestCommonPrefix(String[] strs) {
        for(String nums: strs){
            Trie temp = root;
            for(char ch: nums.toCharArray()){
                if(!temp.mapp.containsKey(ch)){
                    Trie a = new Trie(ch);
                    temp.mapp.put(ch, a);
                }

                temp = temp.mapp.get(ch);
            }
            temp.leaf = true;
        }

        StringBuilder ans = new StringBuilder();
        Trie temp = root;
        while (temp.mapp.size() == 1 && !temp.leaf) {
            Map.Entry<Character, Trie> entry = temp.mapp.entrySet().iterator().next();
            ans.append(entry.getKey());
            temp = entry.getValue();
        }

        return ans.toString();
    }
}