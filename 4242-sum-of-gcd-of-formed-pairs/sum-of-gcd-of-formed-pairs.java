class Solution {

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];

        int maxx = nums[0];

        for(int i=0; i<n; i++){
            maxx = Math.max(nums[i], maxx);
            pre[i] = maxx;
        }
        
        for(int i=0; i<n; i++){
            pre[i] = gcd(pre[i], nums[i]);
        }

        Arrays.sort(pre);

        long ans = 0;

        int i = 0;
        int j = n-1;

        while(i < j){
            int a = gcd(pre[i], pre[j]);
            ans += (long)a;
            i++;
            j--;
        }

        return ans;
    }
}