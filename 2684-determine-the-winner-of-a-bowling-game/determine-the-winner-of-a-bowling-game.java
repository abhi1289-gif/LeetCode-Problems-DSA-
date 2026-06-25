class Solution {
    public int isWinner(int[] nums, int[] arr) {
        int n = nums.length;
        if(n == 1){
            if(nums[0] > arr[0]) return 1;
            else if(nums[0] < arr[0]) return 2;
            return 0;
        }
        int p1 = 0;
        int p2 = 0;

        int num = 0;
        int a = 0;

        num += nums[0];
        a += arr[0];

        if(nums[0] == 10) num += nums[1]*2;
        else num += nums[1];

        if(arr[0] == 10) a += arr[1]*2;
        else a += arr[1];

        for(int i=2; i<n; i++){
            if(nums[i-1] == 10 || nums[i-2] == 10) num += nums[i]*2;
            else num += nums[i];

            if(arr[i-1] == 10 || arr[i-2] == 10) a += arr[i]*2;
            else a += arr[i];
        }

        if(num > a) return 1;
        else if(num < a) return 2;

        return 0;
    }
}