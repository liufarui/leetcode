package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/28 10:05
 * 
 * 4. 寻找两个正序数组的中位数
 * 
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 解题思路：
 * 本提解题思路不难，但是实现非常繁琐，主要是为了好理解，所以代码没有去简洁化；
 * 实现繁琐的主要原因在于需要考虑的边界条件太多，导致有很多条件语句。
 * 代码内部增加了注释，方便查看。
 * 主要思路为：
 * 要找中位数，实际上是要找两个数组组合之后的最中间的数，或者最中间的两个数的平均值
 * 如果要找第n个数，我们可以在两个数组里面各找出其第n/2个数，作比较
 * 然后我们就可以排除这两个数中间，小一点的那个数前面的所有数了
 * 然后依次往后进行判断，详细解法如下：
 */
public class _4_findMedianSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {2, 2, 2, 2};
//        int[] nums2 = {2, 2, 2};
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int median;

        /* 临界值判断，如果两个数组有一个数组长度为0，则直接返回另外一个数组的中位数 */
        if (length % 2 == 0) {
            if (length1 == 0) {
                return (double) (nums2[length2 / 2] + nums2[length2 / 2 - 1]) / 2;
            } else if (length2 == 0) {
                return (double) (nums1[length1 / 2] + nums1[length1 / 2 - 1]) / 2;
            }
        } else {
            if (length1 == 0) {
                return nums2[length2 / 2];
            } else if (length2 == 0) {
                return nums1[length1 / 2];
            }
        }

        /* 判断中位数位置，注意总数为偶数个和奇数个要分类讨论
         * 如果总数为偶数，那么我们寻找两个最中间的数的前一个值 */
        if (length % 2 == 0) {
            median = (length >> 1) - 1;
        } else {
            median = length >> 1;
        }
        int start1 = 0;
        int start2 = 0;

        /* 中位数的候补位置加起来不能大于中位数位置
         * 比如说中位数位置是5，那么候补位置只能是1+4，2+3 */
        while (start1 + start2 < median) {
            /* 偏移量，两个指针往后的步数
             * 在这种情况下，偏移后的位置绝对不会大于中位数的位置
             * 因为每次只会有一个指针偏移，这样的话依次最多偏移以下步数
             * */
            int add = (median - start1 - start2 - 1) >> 1;
            /* 临时记录如果往后移动的话，移动之后的位置 */
            int start1Tmp;
            int start2Tmp;

            /* 如果往后偏移的时候，越界了，则记录为队尾 */
            if (start1 + add < length1) {
                start1Tmp = start1 + add;
            } else {
                start1Tmp = length1 - 1;
            }
            if (start2 + add < length2) {
                start2Tmp = start2 + add;
            } else {
                start2Tmp = length2 - 1;
            }

            /* 判断需要偏移的是哪个指针 */
            if (nums1[start1Tmp] < nums2[start2Tmp]) {
                start1 = start1Tmp + 1;

                /* 增加判断，如果有一个数组的指针偏移到了队尾，则从另外一个数组直接返回 */
                if (start1 > length1 - 1) {
                    if (length % 2 == 0) {
                        return (double) (nums2[median - length1] + nums2[median - length1] + 1) / 2;
                    } else {
                        return nums2[median - length1];
                    }
                }
            } else {
                start2 = start2Tmp + 1;
                if (start2 > length2 - 1) {
                    if (length % 2 == 0) {
                        return (double) (nums1[median - length2] + nums1[median - length2] + 1) / 2;
                    } else {
                        return nums1[median - length2];
                    }
                }
            }
        }

        /* 分类讨论，总数是偶数或者奇数 */
        if (length % 2 == 0) {
            int temp1, temp2;

            /* 寻找当前指针的最小值作为中间的数的前一个数
             * 然后被使用的数的指针++ */
            if (nums1[start1] < nums2[start2]) {
                temp1 = nums1[start1];
                start1++;
            } else {
                temp1 = nums2[start2];
                start2++;
            }
            /* 边界值判断，如果有一个数组指针到了队尾，则直接使用另外一个数组上的指针对应的值 */
            if (start1 == length1) {
                temp2 = nums2[start2];
            } else if (start2 == length2) {
                temp2 = nums1[start1];
            } else {
                /* 然后再次判断当前指针的最小值作为中间数的后一个数 */
                temp2 = Math.min(nums1[start1], nums2[start2]);
            }

            return (double) (temp1 + temp2) / 2;
        } else {
            /* 总数为奇数，则直接返回当前指针最小值 */
            return Math.min(nums1[start1], nums2[start2]);
        }
    }
}
