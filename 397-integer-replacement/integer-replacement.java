class Solution {

    int ans;
    HashMap<Long, Integer> mapp;

    public int travel(long n){
        if(n == 1){
            return 0;
        }

        if(mapp.containsKey(n)) return mapp.get(n);

        if(n%2 == 0){
            int a = 1 + travel(n/2);
            mapp.put(n, a);
            return a;
        }
        else{
            int a = 1 + travel(n+1);
            int b = 1 + travel(n-1);
            mapp.put(n, Math.min(a, b));
            return Math.min(a, b);
        }
    }

    public int integerReplacement(int n) {
        mapp = new HashMap<>();
        return travel((long)n);
    }
}