class Solution {
    public int addDigits(int num) {
        int root=0;
        while(num>0){
            root +=num%10;
            num /=10;
            if(num==0 && root>9){
                num = root;
                root=0;
            }
        }   
        return root;
    }
}