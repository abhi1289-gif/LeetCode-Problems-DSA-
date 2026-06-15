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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        // from 1
        int fs = k;
        // from 0
        int fe = n-k;

        temp = head;
        while(fs>1 && temp != null){
            fs--;
            temp = temp.next;
        }

        ListNode trial = head;

        while(fe>0){
            fe--;
            trial = trial.next;
        }

        int a = trial.val;
        trial.val = temp.val;
        temp.val = a;

        return head;
    }
}