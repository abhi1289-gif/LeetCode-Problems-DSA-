class Solution {

    public boolean isPrime(int a){
        if(a <= 1) return false;
        if(a == 2) return true;
        if(a % 2 == 0) return false;

        for(int i = 3; i * i <= a; i += 2){
            if(a % i == 0){
                return false;
            }
        }

        return true;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        HashMap<Integer, List<Integer>> mapp = new HashMap<>();
        int maxx = -1;
        for(int num: nums) maxx = Math.max(maxx, num);
        
        int dist[] = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);

        for(int i = 0; i < n; i++){
            mapp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        while(qu.size() > 0){
            int curr = qu.poll();

            List<Integer> canGo = new ArrayList<>();

            if(curr-1 >= 0) canGo.add(curr-1);
            if(curr+1 < n) canGo.add(curr+1);

            if(isPrime(nums[curr])){
                int p = nums[curr];
                for(int i=p; i<=maxx; i+=p){
                    if(mapp.containsKey(i)){
                        canGo.addAll(mapp.get(i));
                        mapp.remove(i);
                    }
                }
            }
            for(int nxt: canGo){
                if(dist[nxt] == -1){
                    dist[nxt] = dist[curr]+1;
                    if(nxt == n-1) return dist[nxt];
                    qu.add(nxt);
                }
            }
        }
        return dist[n-1];
    }
}   