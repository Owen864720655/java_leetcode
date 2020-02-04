package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: Longest Substring Without Repeating Characters
 * 
 * <p>
 * Given a string, find the length of the <b>longest substring</b> without
 * repeating characters.
 * 
 * <p>
 * <b>Example 1:</b>
 * <p>
 * Input: "abcabcbb"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * <p>
 * <b>Example 2:</b>
 * <p>
 * Input: "bbbbb"
 * <p>
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * 
 * <p>
 * <b>Example 3:</b>
 * <p>
 * Input: "pwwkew"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * <p>
 * {@link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters}
 *
 */
public class Problem3LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int start = 0;
		int end = 0;
		int answer = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(length);

		for (end = 0; end < length; end++) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				answer = Math.max(answer, end - start);
				start = Math.max(start, map.get(c));
			}
			map.put(c, end + 1);
		}

		answer = Math.max(answer, end - start);

		return answer;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		// String s = "bbbbb";
		// String s = "pwwkew";
		// String s = "au";
		// String s = "cdd";
		s = "abba";

		Problem3LongestSubstringWithoutRepeatingCharacters problem = new Problem3LongestSubstringWithoutRepeatingCharacters();
		int answer = problem.lengthOfLongestSubstring(s);
		System.out.println(answer);
	}

}
