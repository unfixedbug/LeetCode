class Solution {
    public int removePalindromeSub(String s) {
        if(s.isEmpty())return 0;
        else{
            //check whether it is a palindrome
            String reversedS = new StringBuilder(s).reverse().toString();
            if(s.equals(reversedS))return 1;
            else return 2;
        }
    }
}