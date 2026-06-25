class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        for(int num: gifts){
            pq.add(num);
        }

        while(k > 0){
            k--;
            int a = pq.poll();
            int temp = (int) Math.sqrt(a);
            pq.add(temp);
        }

        long ans = 0;

        while(pq.size() > 0){
            int a = pq.poll();
            ans += (long)(a);
        }

        return ans;
    }
}