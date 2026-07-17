class Solution {

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public long maxScore(int[] nums) {
        if (nums.length == 1) return (long) nums[0]*nums[0];

        long ans = 0;

        long l = nums[0];
        long g = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l = lcm(l, nums[i]);
            g = gcd(g, nums[i]);
        }
        ans = l * g;

        for (int i = 0; i < nums.length; i++) {
            long temp = nums[0];
            long trial = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (i == j) continue;
                temp = lcm(temp, nums[j]);
                trial = gcd(trial, nums[j]);
            }

            ans = Math.max(ans, temp*trial);
        }

        l = nums[1];
        g = nums[1];
        for (int i = 2; i < nums.length; i++) {
            l = lcm(l, nums[i]);
            g = gcd(g, nums[i]);
        }
        ans = Math.max(ans, l*g);

        return ans;
    }
}