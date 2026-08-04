class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int road[]: roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        for(int i=0; i<n; i++) pq.add(graph.get(i).size());

        int a = pq.size();

        long ans = 0;

        while(pq.size() > 0){
            ans += (long)pq.poll()*a;
            a--;
        }

        return ans;
    }
}