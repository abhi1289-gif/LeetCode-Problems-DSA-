/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};
        List<Integer> nums = new ArrayList<>();
        ListNode prev = head;
        ListNode temp = head.next;
        int idx = 1;

        while(temp.next != null){
            if(prev.val < temp.val && temp.val > temp.next.val) nums.add(idx);
            else if(prev.val > temp.val && temp.val < temp.next.val) nums.add(idx);

            idx++;
            prev = temp;
            temp = temp.next;
        }
        
        if(nums.size() < 2) return new int[]{-1, -1};

        int maxx = nums.get(nums.size()-1) - nums.get(0);
        int minn = Integer.MAX_VALUE;

        for(int i=0; i<nums.size()-1; i++){
            minn = Math.min(minn, nums.get(i+1)-nums.get(i));
        }

        return new int[]{minn, maxx};
    }
}