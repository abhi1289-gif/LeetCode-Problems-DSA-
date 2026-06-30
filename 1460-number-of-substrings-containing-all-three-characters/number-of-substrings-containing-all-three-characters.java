class Solution {
    public int numberOfSubstrings(String s) {
        // a b c
        int nums[] = new int[]{0, 0, 0};
        int ans = 0;
        int i = 0;
        
        for(int j=0; j<s.length(); j++){
            nums[s.charAt(j)-'a']++;

            while(i < j && nums[0]>0 && nums[1]>0 && nums[2]>0){
                nums[s.charAt(i)-'a']--;
                i++;
                ans += s.length() - j;
            }
        }

        return ans;
    }
}