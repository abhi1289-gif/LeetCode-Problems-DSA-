class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mapp.put(nums[i], mapp.getOrDefault(nums[i], 0) + 1);
        }

        int arr[] = new int[mapp.size()];
        int a = 0;

        for(int num: mapp.keySet()) arr[a++] = num;

        int ans = 0;

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(Math.abs(arr[i]-arr[j]) == k) ans++;
            }
        }

        if(k==0){
            for(int key: mapp.keySet()){
                if(mapp.get(key) > 1) ans++;
            }
        }

        return ans;
    }
}