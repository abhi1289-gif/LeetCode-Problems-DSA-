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
    public int pairSum(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            nums.add(temp.val);
            temp = temp.next;
        }

        int n = nums.size();
        int maxx = Integer.MIN_VALUE;

        for(int i=0; i<n/2; i++){
            maxx = Math.max(maxx, nums.get(i)+nums.get(n-1-i));
        }

        return maxx;
    }
}