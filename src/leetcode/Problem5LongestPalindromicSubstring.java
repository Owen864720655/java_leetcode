package leetcode;

/**
 * Problem 5: Longest Palindromic Substring.
 * 
 * <p>
 * Given a string <b>s</b>, find the longest palindromic substring in <b>s</b>.
 * You may assume that the maximum length of <b>s</b> is 1000.
 * add up to a specific target.
 * 
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is not a valid answer.
 * 
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * 
 * {@link https://leetcode-cn.com/problems/longest-palindromic-substring}
 * 
 */
public class Problem5LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int length = s.length();
		int start = 0, end = 0;

		for (int i = 0; i < length; i++) {
			if (length - i - 1 < (end - start) / 2) {
				break;
			}

			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);

			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2 + 1;
			}
		}
		return s.substring(start, end);
	}

	public int expandAroundCenter(String s, int left, int right) {
		int l = left, r = right;

		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		return r - l - 1;
	}

	public static void main(String[] args) {
		// String s = "babad";
		String s = "cbbd";

		Problem5LongestPalindromicSubstring problem = new Problem5LongestPalindromicSubstring();
		String reuslt = problem.longestPalindrome(s);

		System.out.println(reuslt);
	}
}
