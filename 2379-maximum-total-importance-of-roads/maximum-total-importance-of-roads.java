class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int nums[] = new int[n];
        for(int road[]: roads){
            nums[road[0]]++;
            nums[road[1]]++;
        }

        Arrays.sort(nums);
        long ans = 0;

        for(int i=0; i<nums.length; i++){
            ans += (long)nums[i]*(i+1);
        }

        return ans;
    }
}