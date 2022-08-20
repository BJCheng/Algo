package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static String solution(int k, String s) {
        int left=0, right=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxOccurence = -1;
        int result = 0;
        for(; right<s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxOccurence = Math.max(maxOccurence, map.get(c));
            while((right-left+1) - maxOccurence > k) { // 一定是出現了一個不是maxOccurrence的字元
                Character leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                maxOccurence = Math.max(maxOccurence, map.get(leftChar));
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return "";
    }

    @Test
    public void test() {
        // k=2, 123aaa2caacccccc
        // k=2,
    }
}
