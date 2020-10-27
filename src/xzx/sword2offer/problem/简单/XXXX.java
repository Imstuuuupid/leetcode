package xzx.sword2offer.problem.简单;

import java.util.Arrays;

/**
 * 题目：
 * 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 */
public class XXXX {
    /**
     * 思路：
     * 对数组排序，然后切割
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
       Arrays.sort(arr);
       return Arrays.copyOf(arr,k);

    }
}
