class Solution {

    int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[st.peek()]>arr[i]) st.pop();
            left[i] = (st.size()==0)? i+1: i-st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(st.size() > 0 && arr[st.peek()]>=arr[i]) st.pop();
            right[i] = (st.size()==0)? n-i: st.peek()-i;
            st.push(i);
        }

        long ans = 0;

        for(int i=0; i<n; i++){
            ans = (ans + ((long)left[i]*right[i]*arr[i])%mod)%mod;
        }

        return (int)ans;
    }
}