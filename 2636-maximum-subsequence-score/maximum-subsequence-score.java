class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int nums[][] = new int[n][2];

        for(int i=0; i<n; i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b)-> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans = 0;
        long sum = 0;

        for(int i=0; i<n; i++){
            int num1 = nums[i][0];
            int num2 = nums[i][1];

            sum += num1;
            pq.add(num1);

            if(pq.size() > k){
                sum -= pq.poll(); 
            }

            if(pq.size() == k){
                ans = Math.max(ans, sum*num2);
            }
        }

        return ans;
    }
}