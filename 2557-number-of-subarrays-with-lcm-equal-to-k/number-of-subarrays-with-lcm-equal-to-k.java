class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            long temp = 1;
            for(int j=i; j<nums.length; j++){
                temp = lcm(temp, nums[j]);
                if(temp == (long)k) ans++;
                if (temp > k || k % temp != 0) break;
            }
        }

        return ans;
    }
}