package xzx.sword2offer.problem.简单;

import xzx.structure.TreeNode;

/**
 * 题目：二叉树的深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LV_I {
    /**
     * 思路：
     * dfs+回溯，记录最大值
     * @param root
     * @return
     */
    int count=0;
    int res=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        count++;
        res=Math.max(res,count);
        dfs(root.left);
        dfs(root.right);
        count--;

    }
}
