public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int bit) {
        int c=0;
        while(bit!=0)
        {
            bit=bit^(bit&(-bit));
            c++;
        }
        return c;
    }
}