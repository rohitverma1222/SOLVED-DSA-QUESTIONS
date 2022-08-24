class Solution {
    static int math=(int)Math.pow(3,19);
    public boolean isPowerOfThree(int n) {
        return (n>0 && math%n==0);
    }
}