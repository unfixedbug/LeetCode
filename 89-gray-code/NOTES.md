// recursive appoach, get n-1th, and add 0,1
[pepcoding op](https://www.youtube.com/watch?v=KOD2BFauQbA&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=5)
​
```java
class Solution {
public List<Integer> grayCode(int n) {
if(n==1){
List<Integer> base = new ArrayList<>();
base.add(0);
base.add(1);
return base;
}
List<Integer> prev = grayCode(n-1);
List<Integer> curr = new ArrayList<>();
for(int i=0;i<prev.size();i++){
//add zero
String s = String.valueOf(prev.get(i));
curr.add(Integer.parseInt("0"+s));
}
for(int i=prev.size()-1;i>=0;i--){
//add one
String s = String.valueOf(prev.get(i));
curr.add(Integer.parseInt("1"+s));
}
return curr;
}
}
```