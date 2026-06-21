class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            long temp = 0;
            for(int j=i; j<nums.length; j++){
                temp += (long)nums[j];
                String s = Long.toString(temp);

                char first = s.charAt(0);
                char last = s.charAt(s.length() - 1);

                if(first == (char)(x+'0') && last == (char)(x+'0')) ans++;
            }
        }
        return ans;
    }
}