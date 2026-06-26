class Solution {

    HashMap<Integer, List<Integer>> graph;
    int temp;

    public void travel(int src, HashSet<Integer> visited){
        temp++;
        visited.add(src);

        for(int nebr: graph.get(src)){
            if(!visited.contains(nebr)){
                travel(nebr, visited);
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        graph = new HashMap<>();

        for(int num: nums){
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

        for(int num: nums){
            temp = 0;
            if(!visited.contains(num)){
                travel(num, visited);
            }
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}