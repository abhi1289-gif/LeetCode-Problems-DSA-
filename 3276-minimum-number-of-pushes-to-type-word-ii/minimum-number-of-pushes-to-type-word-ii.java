class Solution {
    public int minimumPushes(String word) {
        int nums[] = new int[26];
        for(char ch: word.toCharArray()) nums[(int)(ch-'a')]++;

        Arrays.sort(nums);

        int ans = 0;
        int t = 0;
        int a = 1;

        for(int i=25; i>=0; i--){
            if(nums[i] == 0) break;
            ans += a*nums[i];
            t++;
            
            if(t == 8){
                a++;
                t = 0;
            }
        }

        return ans;
    }  
}