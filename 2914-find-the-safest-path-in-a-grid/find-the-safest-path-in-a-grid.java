class Solution {

    public class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public class Pairr{
        int x;
        int y;
        int safe;

        Pairr(int x, int y, int safe){
            this.x = x;
            this.y = y;
            this.safe = safe;
        }
    }


    // travel(nums, visited, 0, 0, n);

    public int maximumSafenessFactor(List<List<Integer>> nums) {
        Queue<Pair> qu = new LinkedList<>();
        int n = nums.size();

        if(nums.get(0).get(0) == 1 || nums.get(n-1).get(n-1) == 1) return 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(nums.get(i).get(j) == 1){
                    nums.get(i).set(j, 0);
                    qu.add(new Pair(i, j));
                }
                else{
                    nums.get(i).set(j, -1);
                }
            }
        }

        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(qu.size() > 0){
            Pair curr = qu.poll();
            int i = curr.x;
            int j = curr.y;
            int val = nums.get(i).get(j);

            for(int d[]: dir){
                int x = i + d[0];
                int y = j + d[1];

                if(x<0 || y<0 || x>=n || y>=n || nums.get(x).get(y) != -1) continue;

                nums.get(x).set(y, val + 1);
                qu.add(new Pair(x, y));
            }
        }

        PriorityQueue<Pairr> pq = new PriorityQueue<>((a, b)-> b.safe-a.safe);
        int best[][] = new int[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(best[i], -1);

        pq.add(new Pairr(0, 0, nums.get(0).get(0)));
        best[0][0] = nums.get(0).get(0);
        
        while(pq.size() > 0){
            Pairr curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int safe = curr.safe;

            if(x == n-1 && y == n-1) return safe;

            for(int d[]: dir){
                int a = x + d[0];
                int b = y + d[1];

                if(a<0 || b<0 || a>=n || b>=n) continue;

                int news = Math.min(safe, nums.get(a).get(b));

                if(news > best[a][b]){
                    best[a][b] = news;
                    pq.add(new Pairr(a, b, news));
                }
            }
        }

        return -1;
    }
}