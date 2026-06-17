class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());

        int a = 4;
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<processorTime.size(); i++){
            int b = a*i;

            for(int j=b; j<b+4; j++){
                ans = Math.max(ans, processorTime.get(i)+tasks.get(j));
            }
        }

        return ans;
    }
}