package com.liangwei.leetcode;

/**
 * Created by liangwei on 2017/3/10.
 */
public class Solution {

    public String convert(String s, int numRows) {

        if(s.isEmpty()){
            return "";
        }
        if(s.length()<=numRows||numRows==1){
            return s;
        }
        int interval = 2*numRows -2;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<numRows;i++){

            sb.append(s.charAt(i));

            int tmpInterval = interval-2*i;
            int tmpIndex = i+interval-2*i;

            while(tmpIndex<s.length()){
                if(tmpInterval!=0){

                    sb.append(s.charAt(tmpIndex));
                }
                tmpInterval = interval-tmpInterval;
                tmpIndex = tmpIndex+tmpInterval;
            }
        }
        return sb.toString();
    }
}
