package xzx.tree.easy;

import xzx.structure.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/01 15/24
 */
public class MinDiffInBST {
    private int result = Integer.MAX_VALUE;
    private TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMin(root);
        return result;
    }

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
