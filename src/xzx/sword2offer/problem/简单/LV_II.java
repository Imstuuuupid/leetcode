package xzx.sword2offer.problem.简单;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 * 题目：平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
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
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LV_II {
    /**
     * 思路：
     * 后序遍历判断深度
     * 左右子树深度差不超过1时，取最大深度+1，代表向上返回，
     * 如果超过直接返回-1。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }

    public int dfs(TreeNode root)
    {
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        if(left==-1){
            return -1;
        }
        int right=dfs(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
