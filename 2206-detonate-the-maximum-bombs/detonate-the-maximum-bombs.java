class Solution {

    List<List<Integer>> graph;
    int siz;

    public void travel(int src, boolean visited[]){
        visited[src] = true;
        siz++;

        for(int nebr: graph.get(src)){
            if(!visited[nebr]){
                travel(nebr, visited);
            }
        }
    }

    public boolean inRange(int x1, int y1, int x2, int y2, int r){
        long dx = x1-x2;
        long dy = y1-y2;

        long dist = dx*dx + dy*dy;

        return dist <= (long) r * r;
    }

    public int maximumDetonation(int[][] nums) {
        graph = new ArrayList<>();
        for(int i=0; i<nums.length; i++) graph.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++){
            int x = nums[i][0];
            int y = nums[i][1];

            for(int j=i+1; j<nums.length; j++){
                int a = nums[j][0];
                int b = nums[j][1];

                if(inRange(x, y, a, b, nums[i][2])) graph.get(i).add(j);
                if(inRange(a, b, x, y, nums[j][2])) graph.get(j).add(i);
            }
        }

        int ans = 0;

        for(int i=0; i<nums.length; i++){
            boolean visited[] = new boolean[nums.length];
            siz = 0;
            travel(i, visited);
            ans = Math.max(ans, siz);
        }

        return ans;
    }
}