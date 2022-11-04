class Solution {
    public String reverseVowels(String s) {
        String vow="";
        for(char ch:s.toCharArray()){
            if(isvow(ch))vow+=""+ch;
        }
        char op[] = s.toCharArray();
        
        int ind=vow.length()-1;
        for(int i=0;i<s.length();i++){
            if(isvow(op[i])){
                op[i] = vow.charAt(ind--);
            }
        }
        return new String(op);
        
    }
    
    private boolean isvow(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' )return true;
        return false;
    }
}