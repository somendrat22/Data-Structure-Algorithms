package Dynamic Programming;

public class UglyNumber {
    public int nthUglyNumber(int n) {
        int [] dp = new int[n];
        dp[0] = 1;
        int  two = 0;
        int three = 0;
        int five = 0;

        for(int i = 1; i<dp.length; i++){
            int min = Math.min(2*dp[two], Math.min(3*dp[three], 5*dp[five]));
            dp[i] = min;
            if(min == 2*dp[two]){
                two++;
            }
            if(min == 3*dp[three]){
                three++;
            }
            if(min == 5*dp[five]){
                five++;
            }
        }
        return dp[dp.length - 1];
    }
}
