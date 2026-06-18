class Solution {

    public int findNearestLeft(int val, int nums[]){
        int l = 0;
        int r = nums.length-1;

        int ans = -1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(nums[mid]<=val){
                ans = nums[mid];
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    public int findNearestRight(int val, int nums[]){
        int l = 0;
        int r = nums.length-1;

        int ans = -1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(nums[mid]>=val){
                ans = nums[mid];
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }

    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        
        for(int i=0; i<houses.length; i++){
            int left = findNearestLeft(houses[i], heaters);
            int right = findNearestRight(houses[i], heaters);

            left = (left == -1)? Integer.MAX_VALUE: houses[i]-left;
            right = (right == -1)? Integer.MAX_VALUE: right-houses[i];
            ans = Math.max(ans, Math.min(left, right));
        }
        return ans;
    }
}