class Solution {
    public void reverseString(char[] s) {
        int i=0,j = s.length;
        j--;
        while(i<=j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }
}