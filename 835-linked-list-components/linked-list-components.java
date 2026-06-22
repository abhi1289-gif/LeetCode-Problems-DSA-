class Solution {
    public int numComponents(ListNode head, int[] nums) {
        if(head == null) return 0;

        HashSet<Integer> mapp = new HashSet<>();
        for(int num: nums) mapp.add(num);

        ListNode temp = head;
        int ans = 0;

        while(temp != null){
            if(mapp.contains(temp.val)){
                while(temp != null && mapp.contains(temp.val)) temp = temp.next;
                ans++;
            }
            else temp = temp.next;
        }
        return ans;
    }
}