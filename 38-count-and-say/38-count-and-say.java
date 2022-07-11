class Solution {
    public String countAndSay(int n) {
        //pass the string thrugh the same function n times
        String start = "1";
        for(int i=1;i<n;i++){
            start = recur(start);
        }
        return start;
    }
    
    private String recur(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);// mark the starting char
        int freq=1;// mark the frequency of the character
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==c){// same as the previous chacter
                freq++;
            }else{
                // add the current freq to the new string
                sb.append(freq);
                sb.append(c);
                c = s.charAt(i);// new legacy
                freq=1;
            }
        }
        // last character and last freq remains so add them
        sb.append(freq);
        sb.append(c);
        return sb.toString();
    }
}