package com.liangwei.leetcode;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        String s = "abcabcdbb";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println(length);

        DPSolution dpSolution = new DPSolution();
        s = "uqinntq";
        length = dpSolution.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
