class Solution {
    public int[] relativeSortArray(int[] nums, int[] arr) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int num: nums){
            mapp.put(num, mapp.getOrDefault(num, 0)+1);
        }

        int a = 0;

        for(int num: arr){
            int f = mapp.get(num);
            while(f>0){
                nums[a++] = num;
                f--;
            }
            mapp.remove(num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int key: mapp.keySet()){
            int f = mapp.get(key);

            while(f>0){
                pq.add(key);
                f--;
            }
        }

        while(pq.size() > 0){
            nums[a++] = pq.poll();
        }

        return nums;
    }
}