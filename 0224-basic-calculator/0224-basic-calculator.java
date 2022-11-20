class Solution {
    public int calculate(String s) {
        return evaluate(s);
    }
    
    private int evaluate(String exp) {
        Stack<Integer> nums = new Stack<>();
        int ans = 0, sign = 1;
        // initialize
        nums.push(1);
        // traverse
        for(int i = 0; i < exp.length(); i++) {
            switch(exp.charAt(i)) {
                case ' ' :  break;
                case '(' :
                    nums.push(nums.peek() * sign);
                    sign = 1;
                    break;
                case ')' :
                    nums.pop();
                    break;
                case '+' :
                    sign = 1;
                    break;
                case '-' :
                    sign = -1;
                    break;
                default :   // current character represents a digit
                    int temp = exp.charAt(i) - '0';
                    while (i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1)))
                        temp = temp * 10 + exp.charAt(++i) - '0';
                    ans += sign * nums.peek() * temp;
                    break;
            }
        }
        return ans;
    }
}