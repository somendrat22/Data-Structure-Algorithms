package LeetCode-Contests.Weekly-315;

public class Question3 {
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
    public boolean sumOfNumberAndReverse(int num) {
        int pt = 0;
        while(pt <= num){
            int count = countCharacters(pt);
            int revNum  =  reverseNumber(pt, count);
            if(revNum <= num){
                if(pt + revNum == num){
                    return true;
                }
            }
            pt++;
        }
        return false;
    }
}
