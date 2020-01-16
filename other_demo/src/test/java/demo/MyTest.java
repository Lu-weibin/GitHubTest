package demo;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luwb on 2019/12/30.
 */
public class MyTest {

	@Test
	public void test3() throws IOException {
		InputStream inputStream = new ClassPathResource("test.html").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}

	@Test
	public void test1() {
		int[] ints = {12,12,12,34,57,57,87};
//		System.out.println(removeDuplicates(ints));
//		System.out.println(removeElement(ints,57));
		System.out.println(searchInsert(ints,13));
		System.out.println(Arrays.toString(ints));
	}

	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 你可以假设数组中无重复元素。
	 */
	private int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	/**
	 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 */
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}

	/**
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 */
	private int[] twoSum(int[] nums, int target) {
		int[] arrays = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					arrays[0]=i;
					arrays[1] = j;
					return arrays;
				}
			}

		}
		return null;
	}

	/**
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 */
	public int lengthOfLongestSubstring(String s) {
		// 方法一：暴力法
		/*int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;*/

		// 方法二 滑动窗口法
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;

	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}

}
