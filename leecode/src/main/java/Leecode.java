import org.junit.Test;

/**
 * Created by luwb on 2020/03/27.
 */
public class Leecode {

	// 1. 两数之和

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

	// 9. 回文数

	public boolean isPalindrome(int x) {
		int temp = x;
		if (x < 0 || x % 10 == 0 && x != 0) {
			return false;
		}
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return x == rev || x == rev / 10;
	}

	// 13. 罗马数字转整数

	public int romanToInt(String s) {
		int preNum = getValue(s.charAt(0));
		int sum = 0;
		for (int i = 1; i < s.length(); i++) {
			int current = getValue(s.charAt(i));
			if (preNum < current) {
				sum = sum - preNum;
			} else {
				sum = sum + preNum;
			}
			preNum = current;
		}
		sum = sum + preNum;
		return sum;
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

	// 14. 最长公共前缀

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}


	@Test
	public void test1() {
//		System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
