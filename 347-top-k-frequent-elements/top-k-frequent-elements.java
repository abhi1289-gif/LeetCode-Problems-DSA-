class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int key: freq.keySet()){
            pq.add(new int[]{freq.get(key), key});
            if(pq.size() > k) pq.poll();
        }

        int ans[] = new int[k];
        while(k > 0){
            k--;
            int temp[] = pq.poll();
            ans[k] = temp[1];
        }

        return ans;
    }
}