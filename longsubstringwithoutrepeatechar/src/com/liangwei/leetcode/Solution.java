package com.liangwei.leetcode;

import java.util.Arrays;

/**
 * Created by liangwei on 2017/3/8.
 */
public class Solution {



    //求最长无重复字符的子序列
    public int lengthOfLongestSubstring(String s) {

        int longestLength=0;
        int subStringLength=0;
        int hasVisited[] = new int[256];
        //Arrays arrays = new Arrays(256);
        for(int i=0;i<s.length();i++){

            //重置信息
            subStringLength =0;
            Arrays.fill(hasVisited,0);
            for(int j=i;j<s.length();j++){


                if(hasVisited[s.charAt(j)]!=0){
                    break;
                }
                subStringLength++;
                hasVisited[s.charAt(j)]=1;

                if(subStringLength>longestLength){
                    longestLength =subStringLength;
                }

            }
        }
        return longestLength;
    }
}
