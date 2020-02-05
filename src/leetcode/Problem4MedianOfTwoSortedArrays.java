package leetcode;

/**
 * Problem 4: Median of Two Sorted Arrays
 * 
 * <p>
 * There are two sorted arrays <b>nums1</b> and <b>nums2</b> of size m and n
 * respectively.
 * 
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be {@code O(log(m + n))}
 * 
 * <p>
 * <b>Example 1:</b>
 * <p>
 * nums1 = [1, 3]
 * <p>
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * 
 * <p>
 * <b>Example 2:</b>
 * <p>
 * nums1 = [1, 2]
 * <p>
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3) /2 = 2.5
 * 
 * <p>
 * {@link https://leetcode-cn.com/problems/median-of-two-sorted-arrays}
 *
 */
public class Problem4MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;

		if (left == right) {
			return getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);
		}

		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
				+ getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	private int getKth(int[] nums1, int start1, int end1, int[] nums2,
			int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		// 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (len1 > len2)
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		if (len1 == 0)
			return nums2[start2 + k - 1];

		if (k == 1)
			return Math.min(nums1[start1], nums2[start2]);

		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2,
					k - (j - start2 + 1));
		}
		else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2,
					k - (i - start1 + 1));
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 4, 9 };
		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Problem4MedianOfTwoSortedArrays problem = new Problem4MedianOfTwoSortedArrays();
		double median = problem.findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

}
