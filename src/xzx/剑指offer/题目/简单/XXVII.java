package xzx.剑指offer.题目.简单;

import xzx.剑指offer.题目.结构.TreeNode;

/**
 * 题目：
 * 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class XXVII {
    /**
     * 思路：
     * 直接交换左右节点，然后把左右节点带入、递归。
     * 判断条件为，左右子节点都不为空
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
        {
            return null;
        }
        TreeNode left=mirrorTree(root.left);
        TreeNode right=mirrorTree(root.right);

        root.left=right;
        root.right=left;
        return root;
    }

}
