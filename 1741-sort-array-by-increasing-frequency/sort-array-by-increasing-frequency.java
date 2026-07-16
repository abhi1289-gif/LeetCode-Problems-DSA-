class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int num: nums) mapp.put(num, mapp.getOrDefault(num, 0)+1);
        int arr[][] = new int[mapp.size()][2];

        int a = 0;
        for(int key: mapp.keySet()){
            arr[a][0] = key;
            arr[a][1] = mapp.get(key);
            a++;
        }

        Arrays.sort(arr, (p, q)->{
            if(p[1] != q[1]){
                return p[1]-q[1];
            }

            return q[0]-p[0];
        });

        a = 0;
        for(int i=0; i<arr.length; i++){
            int f = arr[i][1];
            while(f>0){
                f--;
                nums[a++] = arr[i][0];
            }
        }

        return nums;
    }
}