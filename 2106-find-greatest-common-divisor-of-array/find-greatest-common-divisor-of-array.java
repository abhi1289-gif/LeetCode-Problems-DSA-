class Solution {

    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    public int findGCD(int[] nums) {
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            minn = Math.min(minn, nums[i]);
            maxx = Math.max(maxx, nums[i]);
        }

        return gcd(maxx, minn);
    }
}