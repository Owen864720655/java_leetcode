package leetcode;

/**
 * Problem 2: Add Two Numbers
 * 
 * <p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * <p>
 * Example :
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>
 * Output: 7 -> 0 -> 8
 * <p>
 * Explanation: 342 + 465 = 807.
 * <p>
 * 
 * {@link https://leetcode-cn.com/problems/add-two-numbers}
 * 
 */
public class Problem2AddTwoNumbers {
	public Problem2ListNode addTwoNumbers(Problem2ListNode l1,
			Problem2ListNode l2) {
		Problem2ListNode result = new Problem2ListNode(0);

		Problem2ListNode first = l1;
		Problem2ListNode second = l2;
		Problem2ListNode current = result;
		int carry = 0;

		while (first != null || second != null) {
			int firstValue = (first == null) ? 0 : first.val;
			int secondValue = (second == null) ? 0 : second.val;
			int value = firstValue + secondValue + carry;
			carry = value / 10;
			current.next = new Problem2ListNode(value % 10);
			current = current.next;

			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}

		if (carry != 0) {
			current.next = new Problem2ListNode(carry);
		}

		return result.next;
	}

	public static void main(String[] args) {
		// Case 1.
		// ListNode l1 = new ListNode(2);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		//
		// ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);

		Problem2ListNode l1 = new Problem2ListNode(1);
		l1.next = new Problem2ListNode(8);

		Problem2ListNode l2 = new Problem2ListNode(0);

		Problem2AddTwoNumbers problem = new Problem2AddTwoNumbers();
		Problem2ListNode result = problem.addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.println(result.val + "-->");
			result = result.next;
		}
	}
}
