package xzx.tree.easy;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/01 14/47
 */
public class GetMinimumDifference {

    /**
     * 要点有两个：
     * 1、二叉搜索树用中序遍历之后得到的是一个从小到大的排序
     * 2、中序遍历时对根节点的操作可以巧妙地得到 当前节点和前一个节点
     * @author xzx
     * @date 2020/12/01 15:17
     * @param root
     * @return int
     */
    private int result = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMin(root);
        return result;
    }

    /**
     * pre每次必移动
     * @author xzx
     * @date 2020/12/01 15:23
     * @param root
     * @return void
     */
    public void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        getMin(root.right);
    }
}
