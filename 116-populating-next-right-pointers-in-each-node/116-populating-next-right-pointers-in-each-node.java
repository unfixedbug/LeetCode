/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node leftest = root;
        
        while(leftest!=null && leftest.left!=null){// is not last left node, cause perfect binary tree
            Node curr= leftest;
            while(true){
                curr.left.next = curr.right;
                
                //last node
                if(curr.next==null)break; // cause already assigned null!
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            leftest = leftest.left;
        }
        return root;
    }
}