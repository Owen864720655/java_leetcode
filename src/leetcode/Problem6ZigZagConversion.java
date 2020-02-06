package leetcode;

/**
 * Problem 6: ZigZag Problem.
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 * <p>
 * {@code P---A---H---N}
 * <p>
 * {@code A-P-L-S-I-I-G}
 * <p>
 * {@code Y---I---R}
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * <p>
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * <p>
 * {@code string convert(string s, int numRows);}
 * 
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * <p>
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * <p>
 * Output: "PINALSIGYAHRPI"
 * <p>
 * Explanation:
 * <p>
 * {@code P-----I-----N}
 * <p>
 * {@code A---L-S---I-G}
 * <p>
 * {@code Y-A---H-R}
 * <p>
 * {@code P-----I}
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/zigzag-conversion}
 * 
 */
public class Problem6ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		int length = Math.min(s.length(), numRows);
		String rows[] = new String[length];
		for (int i = 0; i < length; i++) {
			rows[i] = "";
		}

		int loc = 0;
		boolean down = false;

		for (int i = 0; i < s.length(); i++) {
			rows[loc] += s.substring(i, i + 1);
			if (loc == 0 || loc == numRows - 1) {
				down = !down;
			}

			loc += down ? 1 : -1;
		}

		StringBuffer sb = new StringBuffer();
		for (String row : rows) {
			sb.append(row);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 4;

		Problem6ZigZagConversion problem = new Problem6ZigZagConversion();
		String result = problem.convert(s, numRows);
		System.out.println(result);
	}

}
