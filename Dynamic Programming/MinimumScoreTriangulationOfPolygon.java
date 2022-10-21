public class MinimumScoreTriangulationOfPolygon {

    // https://en.wikipedia.org/wiki/Polygon_triangulation
    // Concept : Similar to Burst balloons. 
    // This question is done with the help of ear clipping method.
    // We have to hold one edge of the triangel and do the triangulation.
    // Optimally Best part will be taking base as first and last vertex.... but why ? All the options to form a triangel will come between first and last vertex. 
    public int minScoreTriangulation(int[] values) {
        int [][] dp = new int[values.length][values.length];
        int ans = getMinScoreRecurssive(values, 0, values.length - 1, dp);
        return ans;
    }

    private int getMinScoreRecurssive(int [] values, int leftIdx, int rightIdx, int [][] dp){
        if(rightIdx -  leftIdx + 1 < 3){
            return 0;
        }
        if(dp[leftIdx][rightIdx] !=  0){
            return dp[leftIdx][rightIdx];
        }
        int min = Integer.MAX_VALUE;
        for(int i = leftIdx + 1; i < rightIdx; i++){
            int calcLeftSum = getMinScoreRecurssive(values, leftIdx, i, dp);
            int calcRightSum = getMinScoreRecurssive(values, i, rightIdx, dp);
            int myValue = values[leftIdx]*values[i]*values[rightIdx];
            min = Math.min(min, myValue + calcLeftSum + calcRightSum);
        }
        dp[leftIdx][rightIdx] = min;
        return min;
    }
}
