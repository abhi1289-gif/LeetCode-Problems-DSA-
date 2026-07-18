class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int num: asteroids){
            if(num < 0){
                boolean possible = true;
                while(st.size() > 0 && st.peek() > 0){
                    if(Math.abs(num) > st.peek()) st.pop();
                    else if(Math.abs(num) < st.peek()){
                        possible = false;
                        break;
                    }
                    else{
                        st.pop();
                        possible = false;
                        break;
                    }
                }
                if(possible) st.add(num);
            }
            if(num>0) st.add(num);
        }

        int ans[] = new int[st.size()];
        int i = st.size()-1;
        while(st.size() > 0){
            ans[i--] = st.pop();
        }
        return ans;
    }
}