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
    Node head;
    public Node connect(Node root) {
        if (root == null) return null;
        
        if (root.left != null) { // update left next
            if (root.right != null) root.left.next = root.right; // if right child exists - simple connect left.next to right
            else root.left.next = findNext(root); // if not - scan parent next node until we find the first left or right child
        }
        if (root.right != null) { // update right next
            root.right.next = findNext(root);
        }
        
        connect(root.right); // update the right nodes first
        connect(root.left);
        return root;
    }
    
    private Node findNext(Node root) { // get parent node
        while (root.next != null) { // scan all next parent nodes until we find the first left or right child
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
        }
        return null;
    }
}