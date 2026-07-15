class Solution {

    public boolean travel(boolean used[], int currSum, int remSet, int t, int nums[], int idx){
        if(currSum > t) return false;
        if(remSet == 0) return true;
        if(currSum == t){
            return travel(used, 0, remSet - 1, t, nums, 0);
        }

        for(int i=idx; i<nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            if(travel(used, currSum+nums[i], remSet, t, nums, i+1)) return true;
            used[i] = false;
        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) sum += num;

        if(sum % k != 0) return false;
        boolean used[] = new boolean[nums.length];
        int target = sum/k;

        return travel(used, 0, k, target, nums, 0);

    }
}