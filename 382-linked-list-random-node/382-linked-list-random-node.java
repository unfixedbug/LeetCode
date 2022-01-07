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
    Random rand;
    ListNode head;
    int n;
    
    public Solution(ListNode head) {
        this.rand  = new Random();
        this.head = head;
        this.n = 0;
        
        ListNode it = head;
        while(it!=null){
            ++n;
            it = it.next;
        }
    }
    
    public int getRandom() {
        ListNode iter = head;
        int k = rand.nextInt(n);
        
            while(iter !=null){
                if(k==0){
                    return iter.val;
                }
                iter = iter.next;
                --k;
            }
        return -1;
    }
}

class Solution2 {
    private ArrayList<Integer> range = new ArrayList<>();
    
    
    public Solution2(ListNode head) {
        while(head!=null){
            this.range.add(head.val);
            head = head.next;
        }    
    }
    
    public int getRandom() {
        int rand = (int)(Math.random()*this.range.size());
        return this.range.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */