package xzx.tree.easy;

import xzx.structure.TreeNode;
import xzx.tree.structure.Node;

/**
 * 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/05 14/42
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 对多子节点的解法
     * @param root
     * @return
     */
    private int findMax(Node root) {
        if (root == null) {
            return 0;
        }
        //这个变量如果设为全局变量则每return一次就会加一次，导致最初的值失效
        //所以需要在本层设置这个值，及时它在下面几层出现也没有影响，因为最终还是会返回最大层数
        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            maxDepth = Math.max(findMax(root.children.get(i)), maxDepth);
        }
        return 1 + maxDepth;
    }

}
