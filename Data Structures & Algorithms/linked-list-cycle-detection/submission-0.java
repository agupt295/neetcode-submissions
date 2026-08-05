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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode smallHop = head, fastHop = head;
        while(smallHop != null && fastHop != null && fastHop.next != null) {
            smallHop = smallHop.next;
            fastHop = fastHop.next.next;
            if(smallHop == fastHop) {
                return true;
            }
        }
        return false;
    }
}
