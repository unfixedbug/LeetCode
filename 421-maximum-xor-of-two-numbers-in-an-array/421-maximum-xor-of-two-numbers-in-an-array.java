class Node{
    HashMap<Integer, Node> children;
    Node(){
        this.children = new HashMap<>();
    }
}

class Trie{
    Node root;
    
    Trie(){
        this.root= new Node();
    }
    
    public void insert(int[] A){
        for(int num: A){
            // start from the root
            Node curr = this.root;
            // traverse all bits, we take upper bound to be 31
            for(int i=31;i>=0;i--){ // take last, last first, like that, reverse digits 1001
                int currBit = (num>>i)&1;
                if(!curr.children.containsKey(currBit)){
                    curr.children.put(currBit, new Node()); // new reference node
                }
                curr = curr.children.get(currBit); // go deeper inside the trie
                
            }
        }
    }
}

class Solution {
    
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        trie.insert(nums);
        
        int max=0;
        
        for(int num:nums){
            Node curr = trie.root;
            int currSum = 0;
               
        for(int i=31;i>=0;i--){
            int requiredBit = 1-((num>>i)&1); // if a[i] is 0, we need 1, and if 1, we need 0;
            if(curr.children.containsKey(requiredBit)){
                currSum |= (1<<i); /// set ith bit of current result;
                curr = curr.children.get(requiredBit); // go deeper
            }
            else{
                curr = curr.children.get(1-requiredBit); // go with the same bit,
            }
        }
        
        max = Math.max(max, currSum);
        }
        return max;
    }
}
// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/1722805/Java-A-very-detailed-explanation-with-sim.-understanding-or-Trie-%2B-Bit