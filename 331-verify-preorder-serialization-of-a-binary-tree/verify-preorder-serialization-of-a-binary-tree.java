class Solution {
    public boolean isValidSerialization(String preorder) {
        String nums[] = preorder.split(",");
        int c = 1;
        for(String s: nums){
            c--;
            if(c<0) return false;
            if(!s.equals("#")) c+=2;
        }

        return c == 0;
    }
}