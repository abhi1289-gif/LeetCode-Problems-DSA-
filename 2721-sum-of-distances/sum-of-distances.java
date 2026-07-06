class Solution {

    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> mapp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!mapp.containsKey(nums[i])) mapp.put(nums[i], new ArrayList<>());
            mapp.get(nums[i]).add(i);
        }

        long ans[] = new long[nums.length];

        for(List<Integer> temp : mapp.values()) {
            int size = temp.size();

            long totalSum = 0;
            for(int index : temp) {
                totalSum += index;
            }

            long leftSum = 0;

            for(int j = 0; j < size; j++) {
                long index = temp.get(j);

                long left = index * j - leftSum;

                long rightSum = totalSum - leftSum - index;
                long right = rightSum - index * (size - j - 1);

                ans[(int) index] = left + right;

                leftSum += index;
            }
        }

        return ans;
    }
}