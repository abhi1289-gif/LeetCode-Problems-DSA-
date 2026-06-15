class Solution {
    public int balancedString(String s) {
        int arr[] = new int[26];
        int n = s.length();

        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'A']++;
        }

        int ans = s.length();
        int l = 0;
        int t = n/4;

        for(int r=0; r<n; r++){
            arr[s.charAt(r)-'A']--;

            while(l < n && arr['Q' -'A'] <= t && arr['R' -'A'] <= t && arr['W' -'A'] <= t && arr['E' -'A'] <= t){
                ans = Math.min(ans, r-l+1);
                arr[s.charAt(l)-'A']++;
                l++;
            }
        }

        return ans;
    }
}