class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> mapp = new HashMap<>();

        for(char ch: s.toCharArray()){
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);
        }

        HashSet<Character> present = new HashSet<>();

        for(char ch: s.toCharArray()){

            mapp.put(ch, mapp.get(ch)-1);

            if(present.contains(ch)) continue;

            while(st.size() > 0 && st.peek() > ch && mapp.get(st.peek()) > 0){
                present.remove(st.pop());
            }

            st.add(ch);
            present.add(ch);
        }

        StringBuilder ans = new StringBuilder();

        while(st.size() > 0) ans.append(st.pop());
        ans.reverse();
        return ans.toString();
    }
}