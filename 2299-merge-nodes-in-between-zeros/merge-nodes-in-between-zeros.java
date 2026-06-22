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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;

        int a = 0;
        while(temp != null){
            if(temp.val == 0){
                ListNode t = new ListNode(a);
                d.next = t;
                d = t;
                a = 0;
            }
            a += temp.val;
            temp = temp.next;
        }
        return dummy.next;
    }
}