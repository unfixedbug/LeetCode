/*
 *
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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0)return null;
        
        return mergelist(lists,0,k-1);
        
        
    }
    
    private ListNode mergelist(ListNode lists[], int start, int end){
        if(end-start==0) return lists[start];
        if(end-start==1){
            return merge(lists[start], lists[end]);
        }
        
        int mid = start + ((end-start)/2);
        ListNode listA = mergelist(lists, start, mid);
        ListNode listB = mergelist(lists, mid+1, end);
        return merge(listA, listB);
        
    }
    
    // /divide and conquer bitch!
    private ListNode merge(ListNode a, ListNode b){
        if(a==null)return b;
        if(b==null)return a;
        
        if(a.val < b.val){
            a.next = merge(a.next, b);
            return a;
        }
        else{
            b.next = merge(a, b.next);
            return b;
        }
    }
    

}