package xzx.sword2offer.problem.简单;

import xzx.structure.TreeNode;

/**
 * 题目：二叉树最近的公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LXVIII_II {
    /**
     * 思路：
     * 虽然是一道简单题目，但是做起来还是毫无思路= =
     * 然后看题解。
     * 递归
     * 边界条件：
     * 1、到底了，没有找到p或q，返回null
     * 2、找到了p或者q，返回root，即p或q
     * 3、左子树没有找到，返回null，则开启右子树递归
     * 4、右子树没找到，开启左子树递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当遍历到底了，没有找到，返回null； 找到了，就返回这个节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.right, p, q);
        TreeNode right = lowestCommonAncestor(root.left, p, q);
        //左子树没有找到，返回右子树遍历结果
        if (left == null) {
            return right;
        }
        //右子树没有找到，返回左子树遍历结果
        if (right == null) {
            return left;
        }

        return root;

    }
}
