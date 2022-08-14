[striver](https://www.youtube.com/watch?v=l0YC3876qxg)
Strivers
```java
class Solution {
public double myPow(double x, int n) {
double ans=1.0;
long nn = n;
if(nn<0){// if power is negative, make it positive
nn = -1*nn;// made it positive
}
while(nn>0){
if(nn%2==0){//if even
x = x*x;
nn/=2;
}else{
ans = ans*x; // reduce a power
nn-=1;
}
}
// do for the negative
if(n<0)ans = (double)(1.0)/(double)(ans); //  1/x
return ans;
}
}
```
​