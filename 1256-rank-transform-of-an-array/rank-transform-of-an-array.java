class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[]{};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);

        for(int i=0; i<arr.length; i++){
            pq.add(new int[]{arr[i], i});
        }

        int prev = pq.peek()[0];

        int ans[] = new int[arr.length];
        int a = 1;

        while(pq.size() > 0){
            int temp[] = pq.poll();
            if(prev < temp[0]){
                prev = temp[0];
                a++;
            }

            ans[temp[1]] = a;
        }

        return ans;

    }
}