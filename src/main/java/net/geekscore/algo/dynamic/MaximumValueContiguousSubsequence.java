package net.geekscore.algo.dynamic;

/**
 * Created by ravirajmulasa on 12/11/16.
 *
 * Given a sequence of n real numbers A(1) ... A(n),
 * Determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.
 *
 * M(j)= max sum over all windows ending at j.
 * M(j) = Max { M(j-1) + A[j] , A[j]}
 * N sub-problems each take 0(1) time.
 *
 */
public class MaximumValueContiguousSubsequence {

    public static final Long maxValContSeq(final Integer a[]) {
        if(a == null || a.length == 0) {
            return 0L;
        }
        Long sumSoFar   = a[0].longValue();
        Long maxSum     = sumSoFar;
        for (int i = 1; i < a.length; i++) {
            sumSoFar    = Math.max(a[i], sumSoFar + a[i]);
            maxSum      = Math.max(sumSoFar, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxValContSeq(new Integer[]{ -2, 11, -4, 13, -5, 2 }));
        System.out.println(maxValContSeq(new Integer[]{-15, 29, -36, 3, -22, 11, 19, -5}));
        System.out.println(maxValContSeq(new Integer[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
