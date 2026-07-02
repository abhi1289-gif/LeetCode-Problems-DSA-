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
            if(st.size() == 0){
                st.add(new Pair(ch, 1));
            }
            else{
                Pair prev = st.pop();
                if(prev.ch != ch){
                    st.add(prev);
                    st.add(new Pair(ch, 1));
                }
                else{
                    int temp = prev.num;
                    temp += 1;
                    if(temp == k) continue;
                    else st.add(new Pair(ch, temp));
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while(st.size() > 0){
            Pair curr = st.pop();
            int t = curr.num;

            while(t > 0){
                t--;
                ans.append(curr.ch);
            }
        }

        ans.reverse();

        return ans.toString();
    }
}