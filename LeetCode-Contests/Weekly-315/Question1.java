package LeetCode

import java.util.HashSet;

-Contests.Weekly-315;

public class Question1 {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = -1;
        for(int key : set){
            if(set.contains(-key)){
                max = Math.max(key, max);
            }
        }
        return max;
    }
}
