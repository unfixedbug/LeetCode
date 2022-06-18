class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
                
        for (int i =nums2.length-1;i>=0;i--){            
            while (!stack.isEmpty() && nums2[i]> stack.peek()){
                stack.pop();
            }            
            int value = (stack.isEmpty())?-1:stack.peek();
            map.put(nums2[i],value);
            stack.push(nums2[i]);  
        }
        
       int [] result = new int [nums1.length];
        for (int i = 0;i<nums1.length;i++){
             result[i]=map.get(nums1[i]);
        }
            
        return result;
    }
}

// O(n) time
// O(n) space
// -->  Map <>  
// ---> Stack<>





