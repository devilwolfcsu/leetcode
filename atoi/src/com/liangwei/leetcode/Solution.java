package com.liangwei.leetcode;

import com.sun.deploy.util.StringUtils;

/**
 * Created by liangwei on 2017/3/10.
 */
public class Solution {

    private final int Max_INT = 2147483647;

    private final int MIN_INT = -2147483648;


    public int myAtoi(String str) {

        String processStr = preProcess(str);
        //如果
        if(processStr.isEmpty()){
            return 0;
        }

        //处理符号
        int  sign =1;
        if(processStr.charAt(0)=='-'){
            sign = -1;
            processStr = processStr.substring(1,processStr.length());
        }else if(processStr.charAt(0)=='+'){
            sign=1;
            processStr = processStr.substring(1,processStr.length());
        }

        if(processStr.isEmpty()||!isValidNum(processStr.charAt(0))){
           return 0;
        }

        int result =0;
        for(int i=0;i<processStr.length();i++){

            if(!isValidNum(processStr.charAt(i))){
                return sign*result;
            }

            int a  = processStr.charAt(i)-'0';
            int tmpResult = result;
            result  = tmpResult*10+ a;
            if(result/10!=tmpResult){
                return sign>0?Max_INT:MIN_INT;
            }
        }

        return sign*result;
    }

    // 1. 去除空格
    private String preProcess(String str){


        //循环找到第一个不是空格的字符
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                return str.substring(i,str.length());
            }
        }
        return "";
    }

    private boolean isValidNum(char c){

        if(c-'0'>=0&&c-'0'<=9){
            return true;
        }
        return false;
    }
}
