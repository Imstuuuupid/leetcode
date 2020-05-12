package xzx.剑指offer.题目.简单;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class findIn2dArray {

    /**
     * 思路：
     * 矩阵特性为：  标志数
     * 左下角标志数：  本行最小，本列最大
     * 右上角标志数：  本行最大，本列最小
     * 从右上角开始比较，如果target大于matrix，则消去行，往下寻找
     * 如果target小于matrix，则消去列，往左寻找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从左下角开始
        int i = matrix.length - 1;
        int j = 0;
        //***********重点，把数组长度减1的变量放在前面，这样就可以防止输入[[]]产生下标溢出
        while ( i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;

    }
}
