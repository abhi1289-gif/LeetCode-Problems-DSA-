class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";

        for(String word: words){
            int temp = 0;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                int idx = (int)(ch-'a');
                temp += weights[idx];
            }

            temp = temp%26;

            ans += (char)('a' + (25-temp));
        }

        return ans;
    }
}