package leetcode;

/**
 * Problem 7: Reverse Integer.
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * <p>
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * <p>
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * <p>
 * Output: 21
 * <p>
 * Note:
 * <p>
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/reverse-integer}
 * 
 */
public class Problem7ReverseInteger {
	public int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			if ((ans * 10) / 10 != ans) {
				ans = 0;
				break;
			}
			ans = ans * 10 + x % 10;
			x = x / 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		int x = 120;
		Problem7ReverseInteger problem = new Problem7ReverseInteger();
		int result = problem.reverse(x);

		System.out.println(result);
	}
}
