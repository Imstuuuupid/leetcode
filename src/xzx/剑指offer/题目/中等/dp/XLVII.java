package xzx.剑指offer.题目.中等.dp;

/**
 * 题目：礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLVII {
    /**
     * 思路：
     * 采用动态规划，
     * 直接在grid上修改可以降低空间复杂度
     * 转移方程：max(grid[i][j-1],grid[i-1][j])+grid[i][j]
     * 边界：grid.length  grid[0].length
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int line = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                //在左上角，不变
                if (i == 0 && j == 0) {
                    continue;
                }
                //在第一行，只能是从左边到达
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                //在第一列，只能从上边到达
                else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
                }

            }
        }
        return grid[row-1][line-1];

    }
}
