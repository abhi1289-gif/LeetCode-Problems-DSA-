class Solution {

    int ans = 0;

    public void makeBinary(int nums[], int n){
        int i = 0;
        while(n>0){
            if(n%2 == 0){
                nums[i++] += 0;
            }
            else{
                nums[i] += 1;
                ans = Math.max(ans, nums[i]);
                i++;
            }
            n = n/2;
        }
        return;
    }

    public int largestCombination(int[] candidates) {
        int nums[] = new int[32];
        for(int num: candidates){
            makeBinary(nums, num);
        }

        return ans;
    }
}