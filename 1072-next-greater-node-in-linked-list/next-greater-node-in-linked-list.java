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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int ans[] = new int[list.size()];
        Stack<Integer> st = new Stack<>();

        for(int i=list.size()-1; i>=0; i--){
            int curr = list.get(i);

            while(st.size() > 0 && st.peek() <= curr) st.pop();

            if(st.size() > 0) ans[i] = st.peek();
            else ans[i] = 0;

            st.add(curr);
        }

        return ans;
    }
}