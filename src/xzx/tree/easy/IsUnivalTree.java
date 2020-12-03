package xzx.tree.easy;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/02 15/31
 */
public class IsUnivalTree {
    /**
     * 这种递归要注意的是当前节点判断的结果也要返回，
     * 另外空节点要返回true
     *
     * @author xzx
     * @date 2020/12/02 15:46
     * @param root
     * @return boolean
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        return isUnival(root, val);

    }

    private boolean isUnival(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && isUnival(root.left, val) && isUnival(root.right, val);
    }
}
