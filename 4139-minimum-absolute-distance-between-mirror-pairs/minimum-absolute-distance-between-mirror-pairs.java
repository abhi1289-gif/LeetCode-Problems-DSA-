class Solution {

    public int reverse(int n){
        int ans = 0;
        while(n > 0){
            ans  = ans*10 + n%10;
            n = n/10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            int a = reverse(nums[i]);
            if(mapp.containsKey(a)){
                ans = Math.min(ans, mapp.get(a)-i);
            }
            mapp.put(nums[i], i);
        }

        return (ans == Integer.MAX_VALUE)? -1: ans;
    }
}