class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--){
            while(st.size() > 0 && st.peek()<nums2[i]) st.pop();

            if(st.size() == 0) mapp.put(nums2[i], -1);
            else mapp.put(nums2[i], st.peek());

            st.add(nums2[i]);
        }

        int ans[] = new int[nums1.length];
        
        for(int i=0; i<nums1.length; i++){
            ans[i] = mapp.get(nums1[i]);
        }

        return ans;
    }
}