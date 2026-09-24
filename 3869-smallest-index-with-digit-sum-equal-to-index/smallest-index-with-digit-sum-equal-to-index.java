class Solution {

    public int findSum(int a){
        int sum = 0;
        while(a > 0){
            sum += a%10;
            a = a/10;
        }
        return sum;
    }

    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(findSum(nums[i]) == i) return i;
        }
        return -1;
    }
}