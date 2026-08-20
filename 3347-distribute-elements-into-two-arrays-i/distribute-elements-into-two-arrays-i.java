class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        
        for(int i=2; i<nums.length; i++){
            int a = arr1.get(arr1.size()-1);
            int b = arr2.get(arr2.size()-1);
            if(a > b) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }

        int ans[] = new int[nums.length];
        int i = 0;
        for(int num: arr1) ans[i++] = num;
        for(int num: arr2) ans[i++] = num;
        return ans;
    }
}