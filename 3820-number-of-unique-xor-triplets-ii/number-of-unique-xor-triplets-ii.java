class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean arr[] = new boolean[2048];
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                arr[nums[i]^nums[j]] = true;
            }
        }

        boolean num[] = new boolean[2048];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<2048; j++){
                if(arr[j] == true) num[j^nums[i]] = true;
            }
        }

        int ans = 0;
        for(int i=0; i<2048; i++) if(num[i]) ans++;
        return ans;
    }
}