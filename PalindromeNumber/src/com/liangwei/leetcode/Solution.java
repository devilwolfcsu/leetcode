package com.liangwei.leetcode;

/**
 * Created by liangwei on 2017/3/13.
 */
public class Solution {

    //回文数字判断
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        if(x<10){
            return true;
        }

        //位数
        int digitNum =0;

        int tmp = x;
        while(tmp>0){
            tmp = tmp/10;
            digitNum++;
        }

        char stringNum[] = new char[digitNum];

        for(int i=0;i<digitNum;i++){
            char a = (char)(x%10+'0');
            x=x/10;
            stringNum[i] = a;
        }

        int startIndex = 0;
        int endIndex = digitNum-1;
        for(int i=0;i<digitNum;i++){
            if(stringNum[startIndex]!=stringNum[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
