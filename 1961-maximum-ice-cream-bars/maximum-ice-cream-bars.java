class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxx = costs[0];
        for(int cost: costs) maxx = Math.max(maxx, cost);
        int count[] = new int[maxx+1];
        for(int i=0; i<costs.length; i++) count[costs[i]]++;

        int a = 0;
        for(int i=0; i<=maxx; i++){
            while(count[i]>0){
                costs[a++] = i;
                count[i]--;
            }
        }
        int sum = 0;
        int ans = 0;
        for(int i=0; i<costs.length; i++){
            sum += costs[i];
            if(sum > coins) return ans;
            ans++;
        }
        return ans;
    }
}