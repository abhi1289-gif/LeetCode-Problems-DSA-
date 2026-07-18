class Solution {

    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            if(temp == k) ans++;
            for(int j=i+1; j<nums.length; j++){
                if(temp < k) break;
                temp = gcd(temp, nums[j]);
                if(temp == k) ans++;
            }
        }

        return ans;
    }
}