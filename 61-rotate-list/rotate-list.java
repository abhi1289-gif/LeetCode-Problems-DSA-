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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        k = k % n;
        if(k == 0) return head;

        ListNode ans;

        k = n - k;
        temp = head;

        while(k > 1){
            k--;
            temp = temp.next;
        }
        ans = temp.next;
        temp.next = null;

        temp = ans;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;

        return ans;
    }
}