class Solution {

    int mod = 1000000007;
    public int maxArea(int h, int w, int[] nums, int[] arr) {
        Arrays.sort(nums);
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);

        int prev = 0;

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]-prev);
            prev = nums[i];
        }

        pq.add(h-prev);

        int maxx1 = pq.poll();

        pq.clear();
        prev = 0;

        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]-prev);
            prev = arr[i];
        }

        pq.add(w - prev);

        int maxx2 = pq.poll();

        return (int)(((long) maxx1 * maxx2) % mod);
    }
}