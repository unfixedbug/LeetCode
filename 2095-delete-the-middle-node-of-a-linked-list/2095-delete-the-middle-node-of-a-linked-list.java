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
        if(head.next==null)return null;
        // get the middle node
        ListNode fast=head.next.next;
        ListNode slow =head;

        //
        while(fast!=null &&fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        
        //remove the node, next to slow
        slow.next = slow.next.next;
        
        return head;
    }
}