class Solution {
    public double myPow(double x, int n) {
       if(n==0)return 1;
        if(n<0){
           // n=-n;
           // x = 1/x;
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2==0)?myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }
}