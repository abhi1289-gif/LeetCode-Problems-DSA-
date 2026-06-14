class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mapp = new HashMap<>();

        long sum = 0;
        for(int i=0; i<n; i++){
            int a = (arr[i]%k+k)%k;
            mapp.put(a, mapp.getOrDefault(a, 0)+1);
        }

        if (mapp.getOrDefault(0, 0) % 2 != 0)
            return false;

        for(int key: mapp.keySet()){
            int freq = mapp.get(key);
            if(key == 0) continue;

            if(2 * key == k) {
                if(freq % 2 != 0) return false;
            }
            else{
                int rem = k - key;
                if(!mapp.containsKey(rem)) return false;
                if(freq != mapp.get(rem)) return false;
            }
        }

        return true;
    }
}