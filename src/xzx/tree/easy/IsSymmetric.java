package xzx.tree.easy;

import xzx.structure.TreeNode;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/05 14/24
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode l, TreeNode r) {
        // 排除都为空的情况
        if (l == null && r == null) {
            return true;
        }
        // 排除一个为空的情况
        if (l == null || r == null) {
            return false;
        }
        // 剩下都不为空的情况
        if (l.val != r.val) {
            return false;
        }
        return symmetric(l.left, r.right) && symmetric(l.right, r.left);
    }
}
