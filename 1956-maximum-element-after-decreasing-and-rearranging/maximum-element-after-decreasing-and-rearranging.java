class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0] != 1) arr[0] = 1;

        for(int i=0; i<arr.length-1; i++){
            if(Math.abs(arr[i+1]-arr[i]) <= 1) continue;
            else arr[i+1] = arr[i] + 1;
        }

        return arr[arr.length-1];
        
    }
}