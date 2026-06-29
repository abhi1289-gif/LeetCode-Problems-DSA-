class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length < 3){
            if(nums.length == 1) return 0;
            if(nums[0] > nums[1]) return 2;
            return 0;
        }

        // int[] arr = nums.clone();
        // Arrays.sort(arr);
        // int a = -1;
        // int b = -1;

        // for(int i=0; i<arr.length; i++){
        //     if(nums[i] != arr[i]){
        //         a = i;
        //         break;
        //     }
        // }

        // if(a == -1) return 0;

        // for(int i=arr.length-1; i>=0; i--){
        //     if(nums[i] != arr[i]){
        //         b = i;
        //         break;
        //     }
        // }

        // return b-a+1;

        int right = -1;
        int maxx = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < maxx) right = i;
            maxx = Math.max(maxx, nums[i]);
        }

        if(right == -1) return 0;

        int left = -1;
        int minn = Integer.MAX_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > minn) left = i;
            minn = Math.min(minn, nums[i]);
        }

        return right-left+1;
    }
}