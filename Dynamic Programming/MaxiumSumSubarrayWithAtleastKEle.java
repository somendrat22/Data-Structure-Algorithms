package Dynamic Programming;

public class MaxiumSumSubarrayWithAtleastKEle {
    private void applyKadanesAlgo(long [] a, long [] dp){
        dp[0] = a[0];
        for(int i = 1; i<dp.length; i++){
            dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
        }
    }
    private long calcMaxSumWithK(long [] a, long [] dp, long [] prefixSum,  int k){
        long max = prefixSum[k-1];
        for(int i = k; i<a.length; i++){
            long sumKWindow = (i - k == - 1 ?  prefixSum[i]  : prefixSum[i] - prefixSum[i - k]);
            long prevValue = (i - k == -1  ? prefixSum[i] : dp[i - k]);
            max = Math.max(max, Math.max(prevValue + sumKWindow, sumKWindow));
        }
        return max;
    }
    private void calcPrefixSum(long [] a, long [] prefixSum){
        prefixSum[0] = a[0];
        for(int i = 1; i<a.length; i++){
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
    }
    public long maxSumWithK(long a[], long n, long k)
    {
        long [] dp = new long[a.length];
        long [] prefixSum = new long[a.length];
        applyKadanesAlgo(a, dp);
        calcPrefixSum(a, prefixSum);
        long res = calcMaxSumWithK(a, dp, prefixSum, (int)k);
        return res;
    }
}
