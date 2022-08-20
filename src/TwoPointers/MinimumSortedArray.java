package TwoPointers;

import org.junit.Test;

import java.util.Arrays;

public class MinimumSortedArray {
    public static int[] solution(int[] ary) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<ary.length; i++) {
            if(ary[i] < max)  {
                right = i;
            } else {
                max = ary[i];
            }
        }
        for(int i=ary.length-1; i>=0; i--) {
            if(ary[i] > min) {
                left = i;
            } else {
                min = ary[i];
            }
        }
        return right <= left ? new int[]{} : Arrays.copyOfRange(ary, left, right+1);
    }

    @Test
    public void test() {
        int[] res = solution(new int[]{1,2,3,6,5,4,7,8,9});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();

        res = solution(new int[]{7,8,9,6,5,4,1,2,3});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();

        res = solution(new int[]{6,5,4,3,2,1,7,8,9});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();

        res = solution(new int[]{1,2,3,9,8,7,6,5,4});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();

        res = solution(new int[]{3,2,1});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();

        res = solution(new int[]{1,2,3});
        Arrays.stream(res).forEach(System.out::print);
        System.out.println();
    }
}
