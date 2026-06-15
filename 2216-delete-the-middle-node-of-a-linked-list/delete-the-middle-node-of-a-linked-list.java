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
    public ListNode deleteMiddle(ListNode head) {
        // int n = 0;
        // ListNode temp = head;

        // while(temp != null){
        //     n++;
        //     temp = temp.next;
        // }

        // if(n < 3){
        //     if(n==1) return null;
        //     else{
        //         head.next = null;
        //         return head;
        //     }
        // }

        // ListNode prev = head;
        // ListNode curr = head.next;
        // n = n/2-1;

        // while(n > 0){
        //     n--;
        //     curr = curr.next;
        //     prev = prev.next;
        // }

        // prev.next = curr.next;

        // return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev == null) return null;

        prev.next = slow.next;

        return head;
    }
}