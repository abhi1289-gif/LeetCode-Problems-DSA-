class Solution {

    HashMap<Integer, List<Integer>> graph;
    int maxx = 0;

    public void dfs(int src, HashSet<Integer> visited){
        maxx += 1;
        visited.add(src);

        for(int nebr: graph.get(src)){
            if(!visited.contains(nebr)){
                dfs(nebr, visited);
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        graph = new HashMap<>();

        for(int num: nums){
            if(graph.containsKey(num)) continue;
            graph.put(num, new ArrayList<>());

            if(graph.containsKey(num-1)){
                graph.get(num-1).add(num);
                graph.get(num).add(num-1);
            }
            if(graph.containsKey(num+1)){
                graph.get(num+1).add(num);
                graph.get(num).add(num+1);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            if(!visited.contains(nums[i])){
                maxx = 0;
                dfs(nums[i], visited);
                ans = Math.max(ans, maxx);
            }
        }

        return ans;
    }
}