class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        int maxx = nums[0];
        int minn = nums[nums.length-1];

        for(int i=0; i<nums.length; i++){
            maxx = Math.max(nums[i], maxx);
            left[i] = maxx;
        }

        for(int i=nums.length-1; i>=0; i--){
            minn = Math.min(nums[i], minn);
            right[i] = minn;
        }

        for(int i=0; i<nums.length; i++){
            if(left[i] - right[i] <= k) return i;
        }

        return -1;
    }
}