package leetcode;

import java.util.regex.Pattern;

/**
 * Problem 8: String to Integer (atoi).
 * 
 * <p>
 * Implement atoi which converts a string to an integer.
 *
 * <p>
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * <p>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * <p>
 * <b>Note:</b>
 * <p>
 * - Only the space character ' ' is considered as whitespace character.
 * <p>
 * - Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: {@code [−2^{31},  2^{31} − 1]}. If
 * the numerical value is out of the range of representable values,
 * {@code INT_MAX (2^{31} − 1}) or {@code INT_MIN (−2^{31})} is returned.
 * 
 * <p>
 * Example 1:
 * <p>
 * Input: "42"
 * <p>
 * Output: 42
 * <p>
 * Example 2:
 * <p>
 * Input: " -42"
 * <p>
 * Output: -42
 * <p>
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign. Then take as many numerical digits as possible, which gets 42.
 * 
 * <p>
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * <p>
 * Output: 4193
 * <p>
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * <p>
 * Example 4:
 * <p>
 * Input: "words and 987"
 * <p>
 * Output: 0
 * <p>
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical digit or a +/- sign. Therefore no valid conversion could be
 * performed.
 * <p>
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * <p>
 * Output: -2147483648
 * <p>
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed
 * integer.   Therefore {@code INT_MIN (−2^{31})} is returned.
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/string-to-integer-atoi}
 * 
 */
public class Problem8StringToInteger_ATOI {
	public int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		Pattern pattern = Pattern.compile("^([\\+\\-]?\\d+)");
		java.util.regex.Matcher matcher = pattern.matcher(str);

		int value = 0;

		if (matcher.find()) {
			try {
				value = Integer.parseInt(matcher.group());
			} catch (Exception e) {
				value = str.charAt(0) == '-' ? Integer.MIN_VALUE
						: Integer.MAX_VALUE;
			}
		}

		return value;
	}

	public static void main(String[] args) {
		String str = "-91283472332";

		Problem8StringToInteger_ATOI problem = new Problem8StringToInteger_ATOI();
		int value = problem.myAtoi(str);

		System.out.println(value);
	}
}
