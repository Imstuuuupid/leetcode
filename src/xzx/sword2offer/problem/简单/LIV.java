package xzx.sword2offer.problem.简单;

import xzx.structure.TreeNode;

/**
 * 题目：二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LIV {
    /**
     * 思路：
     * 二叉搜索树配上中序遍历，是从小到大的排序
     * 将左右子树遍历顺序调换，得到从大到小的排序
     *
     * @param root
     * @param k
     * @return
     */
    int count;
    int res;
    public int kthLargest(TreeNode root, int k) {
        count=k;
        decInorder(root);
        return res;
    }

    public void decInorder(TreeNode root)
    {
        if(root!=null)
        {
            decInorder(root.right);
            if(count==1)
            {
                //找到返回的时候，上层也会判断count，因此要-1
                count--;
                res=root.val;
                //找到了，返回
                return;
            }
            count--;
            decInorder(root.left);
        }
    }
}
