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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode senti = new ListNode(0,head); // o ppoints to head
        //predeccesor
        ListNode pred = senti;
        while(head!=null){
            if(head.next !=null && head.val==head.next.val){
                //move tiill the end of duplicates
                while(head.next!=null && head.val==head.next.val)
                {
                    head = head.next;
                }
//                 skip all duplicates
                pred.next = head.next;
            }
            else{
                pred = pred.next;
            }
                
        
        head = head.next;
        }
        return senti.next;
    }
}