package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestOne {

	public static void main(String[] args) {

		long a = System.currentTimeMillis();
		String[] strs = {"c","c"};
		System.out.println(longestCommonPrefix(strs));
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

	/**
	 * 找出最长的回文子川         运行时间太长 未通过。。。。
	 * @param s
	 * @return
	 */
	private  static String longestPalindrome(String s) {
		
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

	/**
	 * 给定一个 32 位有符号整数，将整数中的数字进行反转。  如果反转后的整数溢出，则返回 0。
	 * @param x
	 * @return
	 */
	private static int reverse(int x) {
        
		//是否是负数
		boolean flag = x < 0 ? true : false;	
		String numStr = flag ? String.valueOf(x).split("-")[1] : String.valueOf(x);
		
		StringBuilder str = new StringBuilder();
		for (int i = numStr.length() - 1; i >= 0; i--) {
			str.append(numStr.charAt(i));			
		}
		int result = 0;
		try {			
			result = Integer.parseInt(str.toString());
		} catch (NumberFormatException e) {
			return 0;
		}
		if (flag) { 
			result = 0 - result;
		}
		
		return result;
    }

	/**
	 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * @param x
	 * @return
	 * 
	 * 2018-11-14
	 */
	private static boolean isPalindrome(int x) {
		
		String numStr = String.valueOf(x);
        if(numStr.startsWith("-")){
        	return false;
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = numStr.length() - 1; i >= 0; i--) {
        	str.append(numStr.charAt(i));
		}
        if (numStr.equals(str.toString())) {
        	return true;
        }
        return false;
    }
	
	/**
	 * 13. 罗马数字转整数
	 * @param s
	 * @return
	 * 
	 * 2018-11-14
	 */
	private static int romanToInt(String s) {

		String ss = s.replaceAll("IV", "A").replaceAll("IX", "B").replaceAll("XL", "E").replaceAll("XC", "F").replaceAll("CD", "G").replaceAll("CM", "H");
//		System.out.println(ss);
		int sum = 0;
		for (int i = 0; i < ss.length(); i++) {
			char ch = ss.charAt(i);
			switch (ch) {
			case 'I':sum+=1;break;
			case 'V':sum+=5;break;
			case 'X':sum+=10;break;
			case 'L':sum+=50;break;
			case 'C':sum+=100;break;
			case 'D':sum+=500;break;
			case 'M':sum+=1000;break;
			case 'A':sum+=4;break;
			case 'B':sum+=9;break;
			case 'E':sum+=40;break;
			case 'F':sum+=90;break;
			case 'G':sum+=400;break;
			case 'H':sum+=900;break;
			}
		}
		return sum;
	}
	        
	/**
	 * 14. 最长公共前缀
	 * @param strs
	 * @return
	 * 
	 * 2018-11-15
	 */
	private static String longestCommonPrefix(String[] strs) {
		
		if (strs.length <= 0) {
			return "";
		}
		String res = "";
		int k = 0;
		while (true) {	
			String head = "";
			try {
				head = strs[0].substring(0, k);				
			} catch (StringIndexOutOfBoundsException e) {
				return res;
			}
			for (int i = 0; i < strs.length; i++) {
                if ("".equals(strs[i])) {
                    return "";
                }
				boolean b = strs[i].startsWith(head);
				if (!b) {
					return res;
				}				
			}
            res = head;
            k++;
		}
    }
	
}
