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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //
        if(head==null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while(left>1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        ListNode leftConnection = prev;
        ListNode tail = curr; // tail will be connected to right connection
        
        
        //reverse the list iteratively
        ListNode nextd=null;
        while(right-->0){
            nextd = curr.next;
            curr.next=prev;
            prev = curr;
            curr = nextd;
        }
        
        if(leftConnection!=null){
            leftConnection.next = prev;// prev is the curr, reversed list
        }else{
            head=prev;
        }
        
        tail.next = curr;
        return head;
    }
}