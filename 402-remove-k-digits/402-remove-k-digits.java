class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c: num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>c){
                k--;
                stack.pop();
            }
            stack.push(c);
        }   
        
        while(!stack.isEmpty()&& k>0){
            k--;
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){//leading zeroes
            sb.deleteCharAt(0);
        }
        if(sb.length()>0){
            return sb.toString();
        }
        else{
            return "0";
        }
        
    }
}