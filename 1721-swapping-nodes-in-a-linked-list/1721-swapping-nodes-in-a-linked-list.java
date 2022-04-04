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
//         two pointer approach
        ListNode fast = head,slow = head,first = head,second = head;
        
        //put fast, k-1 nodes after slow
        for(int i=0;i< (k-1);i++){
            fast = fast.next;
        }
        first = fast; // this is the k-1th node, as list starts from 1, it is (k-1)th node
        
        // now untill fast comes to end
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;
        
//         now swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}