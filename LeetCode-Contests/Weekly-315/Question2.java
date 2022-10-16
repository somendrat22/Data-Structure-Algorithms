package LeetCode

import java.util.HashSet;

-Contests.Weekly-315;

public class Question2 {
    public int countCharacters(int n){
        int count = 0;
        while(n != 0){
            n = n/10;
            count++;
        }
        return count;
    }

    public int reverseNumber(int n, int count){
        int num = n;
        int revNum  =0;
        while(num != 0){
            int dig = num%10;
            revNum += dig*(int) Math.pow(10, count - 1);
            num /= 10;
            count--;
        }
        return revNum;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int ans = 0;
        HashSet<Integer> ansCalc = new HashSet<>();
        for(int i = 0 ; i<nums.length; i++){
            int count = countCharacters(nums[i]);
            int revNum = reverseNumber(nums[i], count);
            //System.out.println(revNum + " " + nums[i]);
            if(!set.contains(revNum)){
                ans += 2;
                set.add(revNum);
                ansCalc.add(nums[i]);
            }else{
                if(!ansCalc.contains(nums[i]))
                ans++;
                ansCalc.add(nums[i]);
            }
        }
        return ans;
    }
}
