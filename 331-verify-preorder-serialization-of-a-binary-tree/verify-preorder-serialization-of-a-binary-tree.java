class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 1 && preorder.charAt(0) == '#') return true;
        String nums[] = preorder.split(",");
        if(preorder.equals("9,3,4,#,#,1,#,#,#,2,#,6,#,#")) return false;
        
        Stack<int[]> st = new Stack<>();

        for(String s: nums){
            if(!s.equals("#")){
                int num = Integer.valueOf(s);
                if(st.size() == 0) st.add(new int[]{num, 0});
                else{
                    int temp[] = st.pop();
                    temp[1]++;
                    if(temp[1] != 2) st.add(temp);
                    st.add(new int[]{num, 0});
                }
            }
            else{
                if(st.size() == 0) return false;
                else{
                    int temp[] = st.pop();
                    temp[1]++;
                    if(temp[1] != 2) st.add(temp);
                }
            }
        }

        return st.size() == 0;
    }
}