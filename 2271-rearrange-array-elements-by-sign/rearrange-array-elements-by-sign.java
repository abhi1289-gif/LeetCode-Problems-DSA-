class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n]; 

        int b = 1;
        int a = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                arr[a] = nums[i];
                a+=2;
            }
            else{
                arr[b] = nums[i];
                b+=2;
            }
        }

        return arr;
    }
}