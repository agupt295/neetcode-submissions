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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode backPtr = head;
        head = head.next;
        ListNode nextPtr = head;

        backPtr.next = null;
        while(head != null) {
            nextPtr = head.next;
            head.next = backPtr;
            backPtr = head;
            head = nextPtr;
        }

        return backPtr;
    }
}
