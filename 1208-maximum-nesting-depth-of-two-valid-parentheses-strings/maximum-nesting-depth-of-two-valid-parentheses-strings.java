class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int depth[] = new int[s.length()];
        int maxx = 0;
        int d = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                d++;
                depth[i] = d%2;
            }
            if(ch == ')'){
                depth[i] = d%2;
                d--;
            }
        }
        return depth;
    }
}