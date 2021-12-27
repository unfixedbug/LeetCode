class Solution {
    public int findComplement1(int num) {
        var bits = (int)(Math.floor(Math.log(num)/Math.log(2))+1);
        var mask = (1<<bits)-1;
        return ~num & mask;
    }
    public int findComplement(int num) {
        return ~num &( Integer.highestOneBit(num)-1);}
}