package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1: Two Sum.
 * 
 * <p>
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/two-sum}
 * 
 */
public class Problem1TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(
				nums.length / 2);

		for (int index = 0; index < nums.length; index++) {
			int value = nums[index];

			if (map.containsKey(target - value)) {
				return new int[] { map.get(target - value), index };
			}
			map.put(value, index);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 18;

		int[] result = new Problem1TwoSum().twoSum(nums, target);

		for (int index = 0; index < result.length; index++) {
			System.out.println(result[index] + " ");
		}
	}

}
