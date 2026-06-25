class Solution {

    public class Pair{
        int node;
        int time;
        
        Pair(int node, int time){
            this.time = time;
            this.node = node;
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        int maxx = -1;
        for(int num: nums) maxx = Math.max(num, maxx);

        boolean prime[] = new boolean[maxx+1];
        for(int i=2; i<=maxx; i++) prime[i] = true;

        for(int i=2; i*i<=maxx; i++){
            if(prime[i]){
                for(int j=i*i; j<=maxx; j+=i){
                    prime[j] = false;
                }
            }
        }

        HashMap<Integer, List<Integer>> pos = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!pos.containsKey(nums[i])) pos.put(nums[i], new ArrayList<>());
            pos.get(nums[i]).add(i);
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0, 0));
        boolean visited[] = new boolean[n];
        visited[0] = true;

        while(qu.size() > 0){
            Pair curr = qu.poll();
            int i = curr.node;
            int t = curr.time;

            if(i == n-1) return t;

            if(i-1>=0 && !visited[i-1]){
                qu.add(new Pair(i-1, t+1));
                visited[i-1] = true;
            }
            if(i+1<n && !visited[i+1]){
                qu.add(new Pair(i+1, t+1));
                visited[i+1] = true;
            }

            if(prime[nums[i]]){
                int p = nums[i];
                for(int m=p; m<=maxx; m+=p){
                    if (!pos.containsKey(m)) continue;

                    for(int j: pos.get(m)){
                        if(!visited[j]){
                            qu.add(new Pair(j, t+1));
                            visited[j] = true;
                        }
                    }
                    pos.get(m).clear();
                }
                prime[p] = false;
            }
        }
        return -1;
    }
}