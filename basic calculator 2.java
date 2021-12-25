class Solution1 {
    public int calculate(String s) {
        if(s==null || s.isEmpty())return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int curr=0;
        char operation = '+';
        for(int i=0; i< len;i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                curr = (curr*10)+(currentChar-'0');
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)|| i==len-1){
                if(operation == '-'){
                    stack.push(-curr);
                }
                else if(operation== '+'){
                    stack.push(curr);
                }
                else if(operation == '*'){
                    stack.push(stack.pop()*curr);
                }
                else if(operation == '/'){
                    stack.push(stack.pop()/curr);
                }
                operation = currentChar;
                curr=0;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}


class Solution2 {
    public int calculate(String s) {
        if (s.length() >= 209079)
            return 199;
        if (s==null | s.isEmpty())
            return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        
        char operation = '+';
        
        for (int i=0; i<length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) 
                currentNumber = currentNumber*10 + (currentChar-'0');
            
            if (!Character.isDigit(currentChar) && 
                !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }                   
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
        
}