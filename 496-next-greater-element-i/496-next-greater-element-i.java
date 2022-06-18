class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> nxg = new HashMap<>();
        int ans[] = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(nums2[nums2.length-1]);
        nxg.put(nums2[nums2.length-1],-1);
        // remove smaller elements
        // topmost element is the next greater element
        // add h=itself to the top
        for(int i=nums2.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i])st.pop();
            if(st.isEmpty()){// itself is the greatest element
                nxg.put(nums2[i],-1);
            }
            else nxg.put(nums2[i],st.peek());
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = nxg.get(nums1[i]);
        }
        return ans;
        
        
    }
}