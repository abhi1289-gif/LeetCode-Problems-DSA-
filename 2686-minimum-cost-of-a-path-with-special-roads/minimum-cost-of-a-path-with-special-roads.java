class Solution {

    public class Pair{
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    HashMap<Integer, List<Pair>> graph;

    public int dijkstra(){
        int src = 0;
        int dest = 1;
        int n = graph.size();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(curr.cost > dist[curr.node]) continue;

            for(Pair next : graph.get(curr.node)){
                if(dist[next.node] > curr.cost + next.cost){
                    dist[next.node] = curr.cost + next.cost;
                    pq.add(new Pair(next.node, dist[next.node]));
                }
            }
        }

        return dist[1];
    }

    public int minimumCost(int[] start, int[] target, int[][] nums) {
        graph = new HashMap<>();
        HashMap<String, Integer> name = new HashMap<>();
        int node = 0;
        String a = start[0] + "#" + start[1];
        name.put(a, node++);
        String b = target[0] + "#" + target[1];
        name.put(b, node++);

        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());

        for(int i=0; i<nums.length; i++){
            a = nums[i][0] + "#" + nums[i][1];
            b = nums[i][2] + "#" + nums[i][3];
            int p = -1;
            int q = -1;

            if(name.containsKey(a)) p = name.get(a);
            else{
                p = node;
                name.put(a, node++);
            }

            if(name.containsKey(b)) q = name.get(b);
            else{
                q = node;
                name.put(b, node++);
            }

            if(!graph.containsKey(p)) graph.put(p, new ArrayList<>());
            if(!graph.containsKey(q)) graph.put(q, new ArrayList<>());
            graph.get(p).add(new Pair(q, nums[i][4]));

            int d1 = Math.abs(nums[i][0] - start[0]) + Math.abs(nums[i][1] - start[1]);
            int d2 = Math.abs(nums[i][2] - start[0]) + Math.abs(nums[i][3] - start[1]);
            int d3 = Math.abs(nums[i][0] - target[0]) + Math.abs(nums[i][1] - target[1]);
            int d4 = Math.abs(nums[i][2] - target[0]) + Math.abs(nums[i][3] - target[1]);

            graph.get(0).add(new Pair(p, d1));
            graph.get(0).add(new Pair(q, d2));
            graph.get(p).add(new Pair(1, d3));
            graph.get(q).add(new Pair(1, d4));

            for(int j=i+1; j<nums.length; j++){
                String n = nums[j][0] + "#" + nums[j][1];
                String m = nums[j][2] + "#" + nums[j][3];
                int x = -1;
                int y = -1;

                if(name.containsKey(n)) x = name.get(n);
                else{
                    x = node;
                    name.put(n, node++);
                }

                if(name.containsKey(m)) y = name.get(m);
                else{
                    y = node;
                    name.put(m, node++);
                }

                if(!graph.containsKey(x)) graph.put(x, new ArrayList<>());
                if(!graph.containsKey(y)) graph.put(y, new ArrayList<>());

                int cost1 = Math.abs(nums[i][0] - nums[j][0]) + Math.abs(nums[i][1] - nums[j][1]);
                int cost2 = Math.abs(nums[i][0] - nums[j][2]) + Math.abs(nums[i][1] - nums[j][3]);
                int cost3 = Math.abs(nums[i][2] - nums[j][0]) + Math.abs(nums[i][3] - nums[j][1]);
                int cost4 = Math.abs(nums[i][2] - nums[j][2]) + Math.abs(nums[i][3] - nums[j][3]); 

                graph.get(p).add(new Pair(x, cost1));
                graph.get(p).add(new Pair(y, cost2));
                graph.get(q).add(new Pair(x, cost3));
                graph.get(q).add(new Pair(y, cost4));

                graph.get(x).add(new Pair(p, cost1));
                graph.get(y).add(new Pair(p, cost2));
                graph.get(x).add(new Pair(q, cost3));
                graph.get(y).add(new Pair(q, cost4));
            }
        }

        int ans = dijkstra();
        return ans;
    }
}