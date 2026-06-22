class Solution {

    public class Pair{
        int pro;
        int val;
        Pair(int pro, int val){
            this.pro = pro;
            this.val = val;
        }
    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        int maxx = -1;

        for(int num: nums){
            maxx = Math.max(num, maxx);
            mapp.put(num, mapp.getOrDefault(num, 0)+1);
        }

        int arr[] = new int[maxx+1];

        for(int key: mapp.keySet()){
            arr[key] = key*mapp.get(key);
        }

        if(arr.length < 4){
            if(arr.length == 3){
                return Math.max(arr[1], arr[0]+arr[2]);
            }
            if(arr.length == 2){
                return Math.max(arr[1], arr[0]);
            }
            if(arr.length == 1) return arr[0];
        }
        
        for(int i=3; i<arr.length; i++){
            arr[i] = arr[i] + Math.max(arr[i-2], arr[i-3]);
        }

        return Math.max(arr[arr.length-1], arr[arr.length-2]);
    }
}