class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();

        int nums[] = new int[26];

        for(char ch: s.toCharArray()){
            nums[(int)(ch-'a')]++;
        }

        char last = '#';

        for(int i=0; i<26; i++){
            if(nums[i] == 0) continue;
            char ch = (char)('a' + i);

            if(nums[i]%2 != 0){
                last = ch;
                nums[i]--;
            }

            int a = nums[i]/2;
            while(a > 0){
                ans.append(ch);
                a--;
            }
        }

        StringBuilder temp = new StringBuilder(ans);
        if(last != '#') ans.append(last);
        ans.append(temp.reverse());

        return ans.toString();
    }
}