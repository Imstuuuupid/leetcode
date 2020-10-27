package xzx.sword2offer.problem.简单;

import java.util.ArrayList;

/**
 *
 * 题目：
 * 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class XXIX {
    /**
     * 思路：
     * 顺时针打印，方向顺序：→ ↓ ← ↑  → ↓ ← ↑
     * 建立一个相同的矩阵，用枝剪的思想，遍历过了就把边界内推
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList<>();
        if(matrix.length==0)
        {
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
        int left=0;
        int right=matrix[0].length-1;
        int up=0;
        int down=matrix.length-1;
        int max=matrix.length*matrix[0].length;
        while (left<=right||up<=down)
        {
            //向右，遍历完了转向下
            for(int j=left;j<=right;j++)
            {
                if(result.size()==max)
                {
                    break;
                }
                result.add(matrix[left][j]);
            }
            up++;
            //向下，遍历完了转向左
            for (int i=up;i<=down;i++)
            {
                if(result.size()==max)
                {
                    break;
                }
                result.add(matrix[i][right]);
            }
            right--;
            //向左，遍历完了向上
            for(int j=right;j>=left;j--)
            {
                if(result.size()==max)
                {
                    break;
                }
                result.add(matrix[down][j]);
            }
            down--;
            //向上，遍历完了向右
            for(int i=down;i>=up;i--)
            {
                if(result.size()==max)
                {
                    break;
                }
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(5);
        System.out.println(arrayList.size());
    }
}
