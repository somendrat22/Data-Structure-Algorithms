package LeetCode

import java.util.HashMap;
import java.util.HashSet;

-Contests.Biweekly-88;

public class Question1 {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> uniqFreq = new HashSet<>();
        boolean allOne = true;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(Character ch : map.keySet()){
            int freq = map.get(ch);
            if(freq != 1){
                allOne = false;
            }
            uniqFreq.add(freq);
        }

        if(uniqFreq.size() == 1 && allOne){
            return true;
        }
        if(uniqFreq.size() > 2 || uniqFreq.size() == 1){
            return false;
        }

        return true;

    }
}
