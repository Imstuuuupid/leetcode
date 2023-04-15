package xzx.tree.easy;

import xzx.structure.TreeNode;

/**
 * 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，
 * 它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/10 18/02
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root = make(0, nums.length - 1, nums);
        return root;
    }

    private TreeNode make(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = make(left, mid - 1, nums);
        root.right = make(mid + 1, right, nums);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrayToBST a = new SortedArrayToBST();
        TreeNode treeNode = a.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
