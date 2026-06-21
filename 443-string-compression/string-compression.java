class Solution {
    public int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        int n = chars.length;
        int i=0;

        while(i<n){
            if(i+1 < n && chars[i] == chars[i+1]){
                int temp = 1;
                ans.append(chars[i]);
                while(i+1 < n && chars[i] == chars[i+1]){
                    temp++;
                    i++;
                }
                ans.append(Integer.valueOf(temp));
                i++;
            }
            else{
                ans.append(chars[i++]);
            }
        }
        for(int j=0; j<ans.length(); j++){
            chars[j] = ans.charAt(j);
        }
        
        return ans.length();
    }
}