package xzx.tree.easy;

import xzx.structure.TreeNode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/11/21 14/48
 */
public class MergeTree {
    /**
     * 同步遍历两棵树，遇到四种情况，则需要以其中之一为标准进行操作（以t1为标准）：
     * ① ：t1->null , t2->null               不管了，返回
     * ② ：t1->nonnull , t2->null            返回
     * ③ ：t1->null , t2->nonnull            t1重定向到t2，返回
     * ④ ：t1->nonnull , t2->nonnull         t1和t2值相加，继续遍历
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        start(t1, t2);
        return t1;
    }

    private void start(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
            l.val += r.val;
        }
        if (r.left != null) {
            if (l.left == null) {
                l.left = r.left;
            } else {
                start(l.left, r.left);
            }
        }

        if (r.right != null) {
            if (l.right == null) {
                l.right = r.right;
            } else {
                start(l.right, r.right);
            }
        }
    }
}
