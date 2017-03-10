package com.liangwei.leetcode;

/**
 * Created by liangwei on 2017/3/9.
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        boolean flag = false;
        //不能整除
        if((m+n+1)%2!=0){
            return (findKth(nums1,0,m-1,nums2,0,n-1,(m+n+1)/2)+findKth(nums1,0,m-1,nums2,0,n-1,(m+n+1)/2+1))/2.0;
        }else{
            return findKth(nums1,0,m-1,nums2,0,n-1,(m+n+1)/2);
        }
    }

    //找到两个已排序数组的第K小的数字

    /**
     *
     * @param nums1  数组1
     * @param start1  开始下标1
     * @param end1 结束下标1
     * @param nums2 数组2
     * @param start2 开始下标2
     * @param end2 结束下标2
     * @param k 第K
     * @return  结果
     */
    private int findKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){

        int length1 = end1-start1+1;
        int length2 = end2-start2+1;
        //保证length1小于length2
        if(length1>length2){
            return findKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        //有一个数组已空
        if(length1==0){
            return nums2[k-1];
        }
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int pa = Math.min(k/2,length1);
        int pb = k-pa;
        if(nums1[start1+pa-1]<nums2[start2+pb-1]){

            return findKth(nums1,start1+pa,end1,nums2,start2,end2,k-pa);
        }else if(nums1[start1+pa-1]>nums2[start2+pb-1]){
            return findKth(nums1,start1,end1,nums2,start2+pb,end2,k-pb);
        }else{
            return nums1[start1+pa-1];
        }
    }

}
