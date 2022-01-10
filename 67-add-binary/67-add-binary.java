class Solution {
    public String addBinary(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() -1;
        int j= num2.length() -1;
        int carry=0;
        while(i>=0 || j>=0){
            int sum=carry;
//             string to number
            if(i>=0)sum += num1.charAt(i) - '0';
            if(j>=0)sum += num2.charAt(j) - '0';
            sb.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        
        if(carry!=0) sb.append(carry);
       return sb.reverse().toString();
    }
}