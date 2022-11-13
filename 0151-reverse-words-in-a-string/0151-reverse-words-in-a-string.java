class Solution {
    public String reverseWords(String s) {
        Stack<String > st =new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){}
            else{
                int start = i;
                while(i<s.length() && s.charAt(i)!=' '){
                    i++;
                }
                int end = i;
                st.push(s.substring(start,end));
            }
        }
         
        String ans = "";
        while(!st.isEmpty()){
            ans+=st.pop()+" ";
        }
        return ans.trim();
    }
}