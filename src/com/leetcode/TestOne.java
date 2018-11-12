package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(lengthOfLongestSubstring("asd"));
//		System.out.println(lengthOfLongestSubstring2("pwwkew"));
		long a = System.currentTimeMillis();
		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long b = System.currentTimeMillis();
		System.out.println("耗时："+(b-a)+"毫秒");
	}

	/**
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int b = nums[j];
				if (a + b == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	/**
	 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
	 * 
	 * @param s
	 * @return
	 */
	private static int lengthOfLongestSubstring2(String s) {
		int max = 0;
		char[] ch = s.toCharArray();
		List<Character> strList = new LinkedList<>();

		for (int i = 0; i < ch.length; i++) {
			if (!strList.contains(ch[i])) {
				strList.add(ch[i]);
				if (strList.size() > max) {
					max = strList.size();
				}
			} else {
				int index = strList.indexOf(ch[i]);
				for (int j = 0; j <= index; j++) {
					strList.remove(0);
				}
				strList.add(ch[i]);
				if (strList.size() > max) {
					max = strList.size();
				}
			}
		}
		return max;
	}

	public static String longestPalindrome(String s) {
		
		int length = s.length();
		String result = "";
		
		for (int i = length; i >= 1; i--) {
			
			for (int j = 0; j < length-i+1; j++) {
				String newStr = s.substring(j, j+i);
				
				//判断是否是回文数
				boolean flag = true;
				int newLength = newStr.length();
				if (newLength % 2 == 0) {					
					for (int k = 0; k < newLength/2; k++) {
						String start = String.valueOf(newStr.charAt(k));
						String end = String.valueOf(newStr.charAt(newLength-1-k));
						if (!start.equals(end)) {
							flag = false;
							break;
						}
					}
				} else {
					for (int k = 0; k < (newLength+-1)/2; k++) {
						String start = String.valueOf(newStr.charAt(k));
						String end = String.valueOf(newStr.charAt(newLength-1-k));
						if (!start.equals(end)) {
							flag = false;
							break;
						}
					}
				}
				if(flag){				
					result = newStr;
					return result;
				}
			}
		}
		
		return result;

	}

}
