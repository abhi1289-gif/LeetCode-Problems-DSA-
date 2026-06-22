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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode last = head;
        while(last.next != null) last = last.next;

        ListNode brk = last;

        ListNode prev = null;
        ListNode curr = head;
        int a = 0;

        while(curr != null){
            if(curr == brk){
                if(a%2 != 0){
                    prev.next = curr.next;
                    last.next = curr;
                    curr.next = null;
                    last = curr;
                    prev = prev.next;
                    curr = prev;
                    a++;
                }
                break;
            }

            if(a%2 == 0){
                prev = curr;
                curr = curr.next;
                a++;
            }
            else{
                prev.next = curr.next;
                last.next = curr;
                curr.next = null;
                last = curr;
                prev = prev.next;
                curr = prev;
                a++;
            }
        }

        return head;
    }
}