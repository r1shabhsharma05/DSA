class Solution {
    static final long M  = 1000000007;
    static long findpower(long a, long b){
        if(b == 0){
            return 1;
        }
       long half = findpower(a,b/2);
       long result = half * half %M;
        if(b%2==1){
            result = (result*a)%M;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long even = findpower(5, (n + 1) / 2);
        long odd = findpower(4, n / 2);

        return (int)((even * odd) % M);
    }
}