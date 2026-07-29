class Solution {
    public int countElements(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int num: nums){
            mapp.put(num, mapp.getOrDefault(num, 0)+1);
        }

        List<int[]> arr = new ArrayList<>();

        for(int key: mapp.keySet()){
            arr.add(new int[]{key, mapp.get(key)});
        }

        Collections.sort(arr, (a, b)->a[0]-b[0]);

        int brr[][] = new int[arr.size()][3];
        int nxt = 0;

        for(int i=arr.size()-1; i>=0; i--){
            brr[i][0] = arr.get(i)[0];
            brr[i][1] = arr.get(i)[1];
            brr[i][2] = nxt;
            nxt += arr.get(i)[1];
        }

        int ans = 0;
        for(int i=0; i<brr.length; i++){
            if(brr[i][2]>=k) ans += brr[i][1];
        }
        return ans;
    }
}