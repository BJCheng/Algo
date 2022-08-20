package TwoPointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrefixSum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        // currSum - prefixSum = target, prefixSum = currSum - target
        // build prefix sum map
        // find if map contains (currSum - target)
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for(int i=0; i<arr.size(); i++) {
            currSum += arr.get(i);
            map.put(currSum, i);
            if(map.containsKey(currSum - target)) {
                List<Integer> result = new LinkedList<>();
                result.add(map.get(currSum - target)+1);
                result.add(i+1);
                return result;
            }
        }
        return new ArrayList<>();
    }

    @Test
    public void test() {
        List<Integer> result = subarraySum(Arrays.asList(1, 3, -3, 8, 5, 7), 5);
        System.out.println(result);
    }
}
