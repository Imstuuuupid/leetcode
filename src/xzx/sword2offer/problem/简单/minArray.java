package xzx.sword2offer.problem.简单;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 */
public class minArray {

    /**
     * 解题思路：
     *      旋转数组特点是，分为左右两个排序数组
     *      所以使用二分法来进行查找
     *      i：头部     j：尾部      m：中部
     *      每一次循环，都将m赋值为（i+j）/2
     *      三种情况：
     *          1、 m < j    这种情况说明m在右排序数组,旋转点在[i,m]之间
     *          2、 m > j    这种情况说明m在左排序数组，旋转点在[m+1,j]之间
     *          3、 m = j    这种情况无法判定，所以将j-1再做判定
     *
     *     坑：       不能把m与i做比较
     *     原因：      当旋转点位置为0时，数组不变，保持右排序没有左排序，此时判定会出错
     *
     * @param numbers
     * @return
     */
    public int minOne(int []numbers)
    {
        int i=0;
        int j=numbers.length-1;
        int m=0;
        while (i<j)
        {
            m=(i+j)/2;
            if(numbers[m]<numbers[j])
            {
                j=m;
            }
            else if(numbers[m]>numbers[j])
            {
                i=m+1;
            }
            else
            {
                j--;
            }
        }
        return numbers[i];

    }
}
