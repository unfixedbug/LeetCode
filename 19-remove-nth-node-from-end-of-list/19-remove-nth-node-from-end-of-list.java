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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,dummy=head,slow=head;
        for(int i=0;i<n;i++){
            if(fast.next==null){
                if(i==n-1){head=head.next;}
                return head;// meaning nth node is head
            }fast = fast.next;
        }
        
        while(fast.next!=null){// slide the window
            fast = fast.next;
            slow  = slow.next;
        }
        // slowth node is at nth from end,now remove the slowt node
        slow.next = slow.next.next;// fuck removed!
        return head;
    }
}