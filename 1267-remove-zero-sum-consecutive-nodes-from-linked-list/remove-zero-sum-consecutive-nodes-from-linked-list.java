class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> nums =  new ArrayList<>();
        while(head != null){
            if(head.val != 0) nums.add(head.val);
            head = head.next;
        }
        
        for(int i=0; i<nums.size(); i++){
            int temp = 0;
            for(int j=i; j<nums.size(); j++){
                temp += nums.get(j);

                if(temp == 0){
                    nums.subList(i, j + 1).clear();
                    i--;
                    break;
                }
            }
        }
        if(nums.size() == 0) return null;

        ListNode ans = new ListNode(nums.get(0));
        ListNode temp = ans;
        for(int i=1; i<nums.size(); i++){
            ListNode a = new ListNode(nums.get(i));
            temp.next = a;
            temp = a;
        }

        return ans;
    }
}