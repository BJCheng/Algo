package SlidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> permutation = new HashMap<>();
        for(char c: s1.toCharArray()) {
            permutation.put(c, permutation.getOrDefault(c, 0) + 1);
        }
        int left=0, right=0, redundantCharCount=0;
        for(; right<s2.length(); right++) {
            char charRight = s2.charAt(right);
            permutation.put(charRight, permutation.getOrDefault(charRight, 0) - 1);
            if(permutation.get(charRight) < 0) {
                redundantCharCount++;
            }
            while(redundantCharCount > 0) {
                char charLeft = s2.charAt(left);
                permutation.put(charLeft, permutation.get(charLeft)+1);
                if(permutation.get(charLeft) == 0) {
                    redundantCharCount--;
                }
                left++;
            }
            if(right-left+1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }
}
