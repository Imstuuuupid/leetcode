package xzx.tree.easy;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.Objects;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: xzx
 * @Date: 2020/10/19 10:35 上午
 **/
public class BalancedBinaryTree {

    /**
     * 思路：
     *      判断一棵二叉树是不是平衡二叉树，可以从底部开始向上进行判断。
     *      如果任意一个结点下的树都是平衡二叉树，则这棵树就是平衡二叉树
     *
     * 解题结构：
     *      后序遍历
     *
     * @Author: xzx
     * @Date: 2020/10/19 10:38 上午
     **/
    public static void main(String[] args) {

    }

    public Boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public Integer height(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        Integer leftHeight = height(root.left);
        Integer rightHeight = height(root.right);
//        结点左子树或者右子数中包含非平衡二叉树  或者此结点非平衡二叉树  -1会一直返回到最上层
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
//            左子树、右子数、自身  都是平衡二叉树  返回这个结点下最大高度
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public Integer carculateHeight(TreeNode b){
        if(b==null){
            return 0;
        }
        int left = carculateHeight(b.left);
        int right = carculateHeight(b.right);

        if(left== -1 || right == -1 || Math.abs(left-right)> 1 ){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
