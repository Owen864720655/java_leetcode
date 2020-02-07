package leetcode;

/**
 * Problem 9: Palindrome Number.
 * 
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * <p>
 * Output: true
 * 
 * <p>
 * Example 2:
 * <p>
 * Input: -121
 * <p>
 * Output: false
 * <p>
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * <p>
 * Example 3:
 * <p>
 * Input: 10
 * <p>
 * Output: false
 * <p>
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * 
 * <p>
 * Could you solve it without converting the integer to a string?
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/palindrome-number}
 * 
 */
public class Problem9PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;

		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		return x == revertedNumber || x == revertedNumber / 10;
	}

	public static void main(String[] args) {
		int x = 12321;

		Problem9PalindromeNumber problem = new Problem9PalindromeNumber();
		boolean result = problem.isPalindrome(x);

		System.out.println(result);
	}
}
