package Dynamic Programming;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long [] dp = new long[n];
        long [] primeIdx = new long[primes.length];
        dp[0] = 1;
        for(int i = 1; i<n; i++){
            long min = (long)Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                min = Math.min(min,(long)(primes[j]*dp[(int)(primeIdx[j])]));
            }
            for(int j = 0; j<primes.length; j++){
                if(min == primes[j]*dp[(int)(primeIdx[j])]){
                    primeIdx[j]++;
                }
            }
            dp[i] = min;
        }
        

        return (int)dp[n-1];
    }
}
