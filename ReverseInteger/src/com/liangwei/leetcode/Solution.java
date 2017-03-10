package com.liangwei.leetcode;

/**
 * Created by liangwei on 2017/3/10.
 */
public class Solution {


    public int reverse(int x) {


        if(x>=0){
            return reverseTheInt(x);
        }

       return -1*reverseTheInt(x*(-1));
    }

    private int reverseTheInt(int x){
        int result = 0;
        int tmp = 0;
        while(x>0){

            int a = x%10;
            x= x/10;
            tmp = result;
            result = result*10+a;
            if(tmp != result/10){
                result = 0;
                break;
            }
        }
        return result;
    }
}
