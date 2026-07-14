class Solution {
    public int firstUniqueEven(int[] nums) {
        Queue<Integer> qu = new LinkedList<>();
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                qu.add(nums[i]);
                mapp.put(nums[i], mapp.getOrDefault(nums[i], 0)+1);
            }
        }
        while(qu.size() > 0){
            int a = qu.poll();
            if(mapp.get(a) == 1) return a;
        }

        return -1;
    }
}