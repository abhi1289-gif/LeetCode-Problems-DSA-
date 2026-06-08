class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int arr[] = new int[n];
        int a = 0;

        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                arr[a++] = nums[i];
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == pivot){
                arr[a++] = nums[i];
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] > pivot){
                arr[a++] = nums[i];
            }
        }

        return arr;
    }
}