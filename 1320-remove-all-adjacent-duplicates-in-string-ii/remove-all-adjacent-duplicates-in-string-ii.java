class Solution {

    public class Pair{
        char ch;
        int num;

        Pair(char ch, int num){
            this.ch = ch;
            this.num = num;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(st.size() > 0 && st.peek().ch == ch){
                Pair temp = st.pop();
                int a = temp.num+1;
                if(a == k) continue;
                st.add(new Pair(ch, a));
            }
            else{
                st.add(new Pair(ch, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        while(st.size() > 0){
            Pair curr = st.pop();
            int a = curr.num;
            while(a > 0){
                ans.append(curr.ch);
                a--;
            }
        }

        ans.reverse();
        return ans.toString();
    }
}