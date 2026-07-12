class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i<s.length()){
            boolean space = false;
            while(i < s.length() && s.charAt(i) == ' '){
                space = true;
                i++;
            }

            if(i==s.length()) break;

            if(space && sb.length() > 0) sb.append(' ');
            
            if(s.charAt(i) != ' ') sb.append(s.charAt(i));
            i++;
        }

        String str = sb.toString();

        String words[] = str.split(" ");

        StringBuilder ans = new StringBuilder();

        for(int j=words.length-1; j>=0; j--){
            String word = words[j];
            ans.append(word);
            if(j != 0) ans.append(' ');
        }

        return ans.toString();
    }
}