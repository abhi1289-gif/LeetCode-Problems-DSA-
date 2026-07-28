class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();

        HashMap<Character, Integer> mapp = new HashMap<>();

        for(char ch: s.toCharArray()){
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);
        }

        List<Character> list = new ArrayList<>();
        for(char key: mapp.keySet()){
            list.add(key);
        }

        Collections.sort(list);
        char last = '#';

        for(char ch: list){
            if(mapp.get(ch)%2 != 0){
                mapp.put(ch, mapp.get(ch) - 1);
                last = ch;
            }
            int a = mapp.get(ch)/2;
            while(a > 0){
                ans.append(ch);
                a--;
            }
        }

        StringBuilder temp = new StringBuilder(ans);
        if(last != '#') ans.append(last);
        ans.append(temp.reverse());

        return ans.toString();
    }
}