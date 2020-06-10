import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by luwb on 2020/03/27.
 */
public class Leecode {

	// 1. 两数之和

	/**
	 * 暴力破解
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				return new int[]{hashMap.get(target - nums[i]), i};
			} else {
				hashMap.put(nums[i], i);
			}
		}
		return null;
	}

	@Test
	public void twoSumTest() {
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
		System.out.println(Arrays.toString(twoSum2(nums, 9)));
	}

	// 7. 整数反转

	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
				return 0;
			}
			rev = rev * 10 + pop;
		}
		return rev;
	}

	@Test
	public void reverseTest() {
		System.out.println(reverse(123));
		System.out.println(reverse(-123456789));
	}

	// 9. 回文数

	public boolean isPalindrome(int x) {
		if (x < 0 || x % 10 == 0 && x != 0) {
			return false;
		}
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return x == reverse || x == reverse / 10;
	}

	@Test
	public void isPalindromeTest() {
		System.out.println(isPalindrome(1234554321));
		System.out.println(isPalindrome(1234));
		System.out.println(isPalindrome(10));
	}

	// 13. 罗马数字转整数

	public int romanToInt(String s) {
		int preNum = getValue(s.charAt(0));
		int sum = 0;
		for (int i = 1; i < s.length(); i++) {
			int currentNum = getValue(s.charAt(i));
			if (preNum < currentNum) {
				sum = sum - preNum;
			} else {
				sum = sum + preNum;
			}
			preNum = currentNum;
		}
		return sum + preNum;
	}

	private int getValue(char ch) {
		switch(ch) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	@Test
	public void romanToIntTest() {
		System.out.println(romanToInt("XII"));
	}

	// 14. 最长公共前缀

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (String str : strs) {
			while (str.startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}

	@Test
	public void longestCommonPrefixTest() {
		String[] strs = {"flower", "flow", "flight"};
		String[] strs2 = {"dog", "racecar", "car"};
		System.out.println(longestCommonPrefix(strs));
		System.out.println(longestCommonPrefix(strs2));
	}

	// 20. 有效的括号

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == ')' || aChar == '}' || aChar == ']') {
				if (stack.empty()) {
					return false;
				} else {
					char popChar = stack.pop();
					if (popChar == '(' && aChar != ')') {
						return false;
					}
					if (popChar == '{' && aChar != '}') {
						return false;
					}

					if (popChar == '[' && aChar != ']') {
						return false;
					}
				}
			} else {
				stack.push(aChar);
			}
		}
		return stack.isEmpty();
	}

	@Test
	public void isValidTest() {
		System.out.println(isValid("(){)}[]"));
	}

	// 21. 合并两个有序链表

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(-1);
		ListNode cur = pre;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 == null ? l2 : l1;
		return pre.next;
	}

	@Test
	public void mergeTwoListsTest() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;

		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		node4.next = node5;
		node5.next = node6;
		ListNode listNode = mergeTwoLists(node1, node4);
		print(listNode);
	}

	private void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}

	// 26. 删除排序数组中的重复项

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	@Test
	public void removeDuplicatesTest() {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	// 27. 移除元素

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	@Test
	public void removeElementTest() {
		int[] nums = {3, 2, 2, 3};
		int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
		System.out.println(removeElement(nums, 3));
		System.out.println(Arrays.toString(nums));
		System.out.println(removeElement(nums2, 2));
		System.out.println(Arrays.toString(nums2));
	}

	// 28. 实现 strStr() Java中的indexOf

	public int strStr(String haystack, String needle) {
		int n = haystack.length();
		int l = needle.length();
		for (int start = 0; start < n - l + 1; start++) {
			if (haystack.substring(start, start + l).equals(needle)) {
				return start;
			}
		}
		return -1;
	}

	@Test
	public void strStrTest() {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
	}

	// 35. 搜索插入位置

	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
			if (i == nums.length - 1) {
				return nums.length;
			}
		}
		return 0;
	}

	// 使用二分法解题

	public int searchInsert2(int[] nums, int target){
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	@Test
	public void searchInsertTest() {
		int[] nums = {1, 3, 5, 6};
		long start = System.currentTimeMillis();
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));
		System.out.println(searchInsert(nums, 0));
		System.out.println("use time:" + (System.currentTimeMillis() - start));
		System.out.println();
		long start2 = System.currentTimeMillis();
		System.out.println(searchInsert2(nums, 5));
		System.out.println(searchInsert2(nums, 2));
		System.out.println(searchInsert2(nums, 7));
		System.out.println(searchInsert2(nums, 0));
		System.out.println("use time:" + (System.currentTimeMillis() - start2));
	}

	// 38. 外观数列 ???

	public String countAndSay(int n) {
		StringBuilder s = new StringBuilder();
		int p1 = 0;
		int cur = 1;
		if ( n == 1 ) {
			return "1";
		}
		String str = countAndSay(n - 1);
		for ( cur = 1; cur < str.length(); cur++ ) {
			// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
			if ( str.charAt(p1) != str.charAt(cur) ) {
				int count = cur - p1;
				s.append(count).append(str.charAt(p1));
				p1 = cur;
			}
		}
		// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
		if ( p1 != cur ){
			int count = cur - p1;
			s.append(count).append(str.charAt(p1));
		}
		return s.toString();
	}

	@Test
	public void countAndSayTest() {
		System.out.println(countAndSay(24));
	}

	// 53. 最大子序和 ???

	public int maxSubArray(int[] nums) {
		int pre = 0;
		int maxAns = nums[0];
		for (int num : nums) {
			pre = Math.max(pre + num, num);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}

	@Test
	public void maxSubArrayTest() {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(nums));
	}

	// 58. 最后一个单词的长度

	public int lengthOfLastWord(String s) {
		if (s.trim().isEmpty()) return 0;
		if (!s.contains(" ")) return s.length();
		String[] strings = s.split(" ");
		return strings[strings.length-1].length();
	}

	@Test
	public void lengthOfLastWordTest() {
		System.out.println(lengthOfLastWord("Hello world"));
	}

	// 66. 加一

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	@Test
	public void plusOneTest() {
		int[] digits = {1, 2, 3};
		int[] digits2 = {4, 3, 2, 1};
		int[] digits3 = {9, 9, 9, 9};
		System.out.println(Arrays.toString(plusOne(digits)));
		System.out.println(Arrays.toString(plusOne(digits2)));
		System.out.println(Arrays.toString(plusOne(digits3)));
	}


	// 67. 二进制求和

	/**
	 * 转数字
	 */
	public String addBinary(String a, String b) {
		return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
	}

	/**
	 * 逐位计算 ???
	 */
	public String addBinary2(String a, String b) {
		int n = a.length(), m = b.length();
		if (n < m) return addBinary(b, a);
		int L = Math.max(n, m);

		StringBuilder sb = new StringBuilder();
		int carry = 0, j = m - 1;
		for(int i = L - 1; i > -1; --i) {
			if (a.charAt(i) == '1') {
				++carry;
			}
			if (j > -1 && b.charAt(j--) == '1') {
				++carry;
			}
			if (carry % 2 == 1) {
				sb.append('1');
			} else {
				sb.append('0');
			}
			carry /= 2;
		}
		if (carry == 1) {
			sb.append('1');
		}
		sb.reverse();

		return sb.toString();
	}

	@Test
	public void addBinaryTest() {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary2("1010", "1011"));
	}

	// 69. x 的平方根

	/**
	 * 二分查找
	 *
	 * 注意整型值溢出
	 */
	public int mySqrt(int x) {
		int left = 0;
		int right = x;
		while (left <= right) {
			//int mid = (left + right) / 2;
			int mid = left + (right - left) / 2;
			long mid2 = (long) mid * mid;
			if (mid2 == x) {
				return mid;
			} else if (mid2 < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left * left == x ? left : left - 1;
	}

	@Test
	public void mySqrtTest() {
		System.out.println(mySqrt(2147395599));
	}

	// 70. 爬楼梯

	public int climbStairs(int n) {

		return 0;
	}

	@Test
	public void climbStairsTest() {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(10));
	}

}
