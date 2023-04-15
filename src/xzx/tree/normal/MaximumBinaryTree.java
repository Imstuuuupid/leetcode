package xzx.tree.normal;

import xzx.structure.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: xzx
 * @Date: 2020/10/30 9:34 上午
 **/
public class MaximumBinaryTree {

    /**
     * 递归三部曲：
     * 1、边界条件
     * 2、递归参数与返回值
     * 3、每一层递归做什么
     *
     * @Author: xzx
     * @Date: 2020/10/30 9:56 上午
     * @Param: [nums]
     * @Return: xzx.structure.TreeNode
     **/
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums , int left , int rigt) {
        if(left == rigt) {
            return null;
        }
        int maxPos = findMax(nums , left , rigt);
        TreeNode n = new TreeNode(nums[maxPos]);
        n.left = construct(nums, left, maxPos - 1);
        n.right = construct(nums, maxPos + 1, rigt);;
        return n;
    }

    private int findMax(int[] nums , int start , int end) {
        int max = Integer.MIN_VALUE;
        int pos = -1 ;
        for (int i = start ; i < end ; i++ ){
            if(nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }
}
