class Solution {

    public long countVowels(String word) {
        long ans = 0;
        int n = word.length();
        int nums[] = new int[n];

        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') nums[i] = 1;
            ans += (long)nums[i]*(i + 1)*(n - i);
        }

        return ans;
    }
}