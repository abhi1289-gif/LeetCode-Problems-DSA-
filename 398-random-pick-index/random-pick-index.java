class Solution {

    HashMap<Integer, List<Integer>> mapp;

    public Solution(int[] arr) {
        mapp = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!mapp.containsKey(arr[i])) mapp.put(arr[i], new ArrayList<>());
            mapp.get(arr[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int siz = mapp.get(target).size();
        int i = (int)(Math.random() * siz);

        return mapp.get(target).get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */