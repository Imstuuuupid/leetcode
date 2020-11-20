package xzx.tree.easy;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/11/20 20/52
 */
public class BinarySumFromRoot2Leaf {

    int res = 0;

    /**
     * 思路：
     *    当前节点值计算为：上一层节点值*2+当前节点值
     *
     */

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return res;
    }

    private void calculate(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res += cur * 2 + root.val;
        }
        calculate(root.left, cur * 2 + root.val);
        calculate(root.right, cur * 2 + root.val);
    }
}
