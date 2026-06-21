class Solution {
    public int furthestBuilding(int[] nums, int b, int l) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length-1; i++){
            int diff = nums[i+1]-nums[i];

            if(diff <= 0) continue;

            pq.add(diff);

            if(pq.size() > l){
                b -= pq.poll();
            }

            if(b < 0) return i;
        }

        return nums.length-1;
    }
}