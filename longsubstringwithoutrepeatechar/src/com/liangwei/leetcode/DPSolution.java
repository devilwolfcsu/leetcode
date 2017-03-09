package com.liangwei.leetcode;

import java.util.Arrays;

/**
 * Created by liangwei on 2017/3/8.
 */
public class DPSolution {

    //动态规划方式解决方案
    public int lengthOfLongestSubstring(String s) {

        int maxSubstringLength = 0;
        int startIndex =0;
        int subStringLength = 0;
        int hasVisited[]  = new int[256];
        //逆向遍历字符串
        Arrays.fill(hasVisited,-1);
        for(int i =0;i<s.length();i++){

            //已经访问过了
            if(hasVisited[s.charAt(i)]!=-1){
                int index = hasVisited[s.charAt(i)];
                //在当前最长子串之前出现，更新信息，并直接+1
                if(index<startIndex){
                    subStringLength++;
                    //hasVisited[s.charAt(i)] = index;
                }else{
                    startIndex = index+1;
                    //hasVisited[s.charAt(i)] = i;
                    subStringLength = i - index;
                }
                hasVisited[s.charAt(i)] = i;

            }else{
                //记录访问的下标位置
                hasVisited[s.charAt(i)]=i;
                subStringLength++;
            }

            //更新最大子串长度信息
            if(maxSubstringLength<subStringLength){
                maxSubstringLength = subStringLength;
            }

        }
        return maxSubstringLength;
    }
}
