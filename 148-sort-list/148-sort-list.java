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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);// left starts from head
        ListNode right = sortList(mid); // right starts from mid
        return merge(left, right);
        
    }
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail=tail.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        tail.next = (l1!=null)?l1:l2; // if any of them is null, next pointer is the other list
        return dummy.next;
    }
    ListNode getMid(ListNode head){
        ListNode mid = null;
        while(head!=null && head.next!=null){
            mid = (mid==null)?head:mid.next; //slow pointer
            head = head.next.next; // fast pointer
        }
        ListNode midp = mid.next;
        mid.next = null;
        return midp;
    }
}