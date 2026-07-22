class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        Stack<Character> st = new Stack<>();

        for(char ch: directions.toCharArray()){
            if(st.size() > 0){
                if(st.peek() == ch){
                    st.add(ch);
                }
                else if(st.peek() == 'S' || ch == 'S'){
                    if(ch == 'S' && st.peek() == 'L'){
                        st.add('S');
                        continue;
                    }
                    if(ch == 'R' && st.peek() == 'S'){
                        st.add('R');
                        continue;
                    }
                    st.pop();
                    ans++;
                    while(st.size() > 0 && st.peek() == 'R'){
                        st.pop();
                        ans++;
                    }
                    st.add('S');
                }
                else{
                    if(st.peek() == 'L' && ch == 'R'){
                        st.add('R');
                        continue;
                    }
                    st.pop();
                    while(st.size() > 0 && st.peek() == 'R'){
                        st.pop();
                        ans++;
                    }
                    st.add('S');
                    ans += 2;
                }
            }
            else{
                st.add(ch);
            }
        }
        return ans;
    }
}