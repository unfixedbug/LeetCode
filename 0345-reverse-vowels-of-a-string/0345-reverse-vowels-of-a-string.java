class Solution {
    public String reverseVowels(String s) {
        
        char op[] = s.toCharArray();
        int i=0,j=s.length()-1;
        
        while(i<j){
            while(i<s.length() && !isvow(op[i]))i++;
            
            while(j>0 && !isvow(op[j]))j--;
            
            if(i<j)swap(op,i++,j--);
        }
        return new String(op);
        
    }
    
    private boolean isvow(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' )return true;
        return false;
    }
    
    void swap(char all[], int a, int b){
        char temp = all[a];
        all[a]=all[b];
        all[b]=temp;
    }
}