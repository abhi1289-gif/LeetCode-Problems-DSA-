class Solution {
    public int firstUniqChar(String s) {
        int nums[] = new int[26];
        for(char ch: s.toCharArray()){
            nums[(int)(ch-'a')]++;
        }
        for(int i=0; i<s.length(); i++){
            if(nums[(int)(s.charAt(i)-'a')] == 1) return i;
        }
        return -1;
    }
}