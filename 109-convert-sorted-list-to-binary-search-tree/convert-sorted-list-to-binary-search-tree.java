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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode travel(ListNode head){
        if(head == null) return null;
        if(head.next == null){
            int val = head.val;
            return new TreeNode(val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode lef = head;

        while (fast != null && fast.next != null) {
            lef = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow;
        TreeNode root = new TreeNode(temp.val);
        slow = slow.next;
        temp.next = null;
        lef.next = null;

        root.left = travel(head);
        root.right = travel(slow);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = travel(head);
        return root;
    }
}