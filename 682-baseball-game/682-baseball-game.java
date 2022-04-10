class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for(String op:ops){
            if(op.equals("+")){
                int top = st.pop();
                int newtop = top+ st.peek();
                st.push(top);
                st.push(newtop);
            }else if(op.equals("C"))st.pop();
            else if(op.equals("D")){
                st.push(2*st.peek());
            }
            else{
                st.push(Integer.valueOf(op));
            }
        }
        
        int ans=0;
        for(int score:st)ans+=score;
        return ans;
    }
}