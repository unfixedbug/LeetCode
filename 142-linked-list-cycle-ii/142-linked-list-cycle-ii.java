/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head ==null || head.next==null) return null;
        
        ListNode slow = head, fast=head, start=head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}