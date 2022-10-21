package LeetCode-Contests.Weekly-315;

public class Question4 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        long prev = -1;
        int min = nums[0];
        int max = nums[0];
        if(min == minK && max == maxK){
            count++;
            prev = count;
        }

        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            if(val >= minK && val <= maxK){
                min = Math.min(min, val);
                max = Math.max(max, val);
                if(min == minK && max == maxK){
                    if(prev != -1){
                        count = prev + 1;
                    }else{
                        count += 1;
                        prev = count;
                    }
                }
            }else{
                prev = -1;
            }
        }
        return count;
    }
}
