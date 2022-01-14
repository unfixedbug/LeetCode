class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index=0;
        int n = s.length();
        
        while(index<n && s.charAt(index)==' '){
            index++;
        }// remove begining spaces;
        
        if(index<n && s.charAt(index)=='+'){//sign+1,for poisitve, -1 for negative
            sign=1;
            index++;
        }
        else if(index<n && s.charAt(index)=='-'){
            index++;
            sign=-1;
        }
        
//         traversing the next digits of input and stop if it is not a d digit
        while(index <n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            
//             overflow underflow conditions;
            if((result > Integer.MAX_VALUE/10) || (result ==Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                
                
                return sign==1?Integer.MAX_VALUE :Integer.MIN_VALUE;
            }
            result  = 10*result + digit;
            index++;
        }
        return sign*result;
    }
}