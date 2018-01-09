package net.geekscore.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *  [-1,  0, 0, 1],
 *  [-2, -1, 1, 2],
 *  [-2,  0, 0, 2]
 * ]
 *
 **/

public class FourSum {

    public static void main(String[] args) {
        System.out.println(quadruplets(new int[]{1, 0, -1, 0, -2, 2}, 0)); //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(quadruplets(new int[]{-3,-2,-1,0,0,1,2,3}, 0)); // [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(quadruplets(new int[]{0,0,0,0}, 0)); // [[0,0,0,0]]
        System.out.println(quadruplets(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9)); // [[-5,-4,-1,1],[-5,-4,0,0],[-5,-2,-2,0],[-4,-2,-2,-1]]
    }

    private static  List<List<Integer>> quadruplets(final int nums[], final int target) {

        if(null == nums && nums.length < 4) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        final List<List<Integer>> quadruplets = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    final int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }

        }

        return quadruplets;
    }

}