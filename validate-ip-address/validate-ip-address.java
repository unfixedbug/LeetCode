import java.net.*;
class Solution {
    public String validIPAddress(String queryIP) {
       if(queryIP.chars().filter(ch -> ch=='.').count() ==3){
           return validateIPv4(queryIP);
       }
        if(queryIP.chars().filter(ch -> ch==':').count() ==7){
           return validateIPv6(queryIP);
       }
        else return "Neither";
    }
    public String validateIPv4(String IP){
        String nums[] = IP.split("\\.",-1);
        for(String x : nums){
            //length of chunk  betn 1 and 3
            if(x.length()==0 || x.length()>3)return "Neither";
            //no leading zeros
            if(x.charAt(0)=='0' && x.length()!=1) return "Neither";
            // only digits
            for(char ch: x.toCharArray()){
                if(!Character.isDigit(ch)) return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
        }
    
    public String validateIPv6(String IP){
        String nums[] = IP.split(":",-1);
        String hexdigits= "0123456789abcdefABCDEF";
        for(String x : nums){
            //validate the range (0,2**16)
            // at least one and atost 4 digits in hexadecimal
            if(x.length() ==0 || x.length() >4) return "Neither";
//             only 0-9 a-f A-F are allowed
            for(Character ch:x.toCharArray()){
                // if(ch is not in hexdigits string )
                if(hexdigits.indexOf(ch)== -1) return "Neither";
            }
        }
        return "IPv6";
        }
}