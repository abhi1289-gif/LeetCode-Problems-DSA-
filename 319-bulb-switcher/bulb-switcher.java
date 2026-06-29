class Solution {
    public int bulbSwitch(int n) {
        // if(n == 0) return 0;
        // boolean bulbs[] = new boolean[n+1];
        // for(int i=0; i<=n; i++) bulbs[i] = true;


        // for(int i=2; i<=n; i++){
        //     for(int j=i; j<=n; j+=i){
        //         bulbs[j] = (bulbs[j])? false: true;
        //     }
        // }

        // int ans = 0;

        // for(int i=0; i<=n; i++){
        //     if(bulbs[i]) ans++;
        // }

        // return ans-1;
        return (int)(Math.sqrt(n));
    }
}