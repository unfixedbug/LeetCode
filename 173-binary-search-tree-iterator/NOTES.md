**another infunction inorder approach**
```java
private TreeNode now;
private Stack<TreeNode> inorder;
public BSTIterator(TreeNode root) {
now = root;
inorder = new Stack();
}
public int next() {
while(now!=null){// traverse, get its left one first
inorder.push(now);
now = now.left;// over the left most?
}
TreeNode next = inorder.pop();// traverse its right
now = next.right;
// return the popped node
return next.val;
}
public boolean hasNext() {
return now!=null || !inorder.isEmpty();
}
```