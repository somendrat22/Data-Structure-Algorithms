public class BurstBalloons{
    int [][] dp;

    // 1. In this if we are at a balloon we will burst it last first we will burst all the ballons which are present in the left of current
    // balloon and the balloons which are on right. Then we will calculate the cost for the current balloon. 

    // 2. We have left and right pointers here which will tell that after all the left & right side balloons will get burst then we will
    // calculate the cost by num[left - 1]*nums[i]*nums[right + 1]. Note* here left and right pointers are not exact i - 1 & i + 1. It is different


    private int calculateMaxCost(int [] nums, int left, int right){
        if(left > right){
            return 0;
        }
        if(dp[left][right] != 0){
            return dp[left][right];
        }
        int max = nums[left];
        for(int i = left; i <= right; i++){
            int leftCost = calculateMaxCost(nums, left, i - 1);
            int rightCost = calculateMaxCost(nums, i + 1, right);
            int currCost = getValue(nums, left - 1)*nums[i]*getValue(nums, right + 1) + leftCost + rightCost;
            max = Math.max(max, currCost);
        }
        dp[left][right]= max;
        return max;
    }

    private int getValue(int [] nums, int idx){
        if(idx <  0 || idx >= nums.length){
            return 1;
        }
        return nums[idx];
    }
    public int maxCoins(int[] nums) {
        this.dp = new int[nums.length][nums.length];
        return calculateMaxCost(nums, 0, nums.length - 1);
    }
}