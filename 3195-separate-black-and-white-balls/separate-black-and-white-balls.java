class Solution {
    public long minimumSteps(String s) {
        long ans = 0;

        int n = s.length();
        int arr[] = new int[n];

        int temp = 0;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                temp++;
            }
            arr[i] = temp;
        }

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                ans += arr[i];
            }
        }

        return ans;
    }
}