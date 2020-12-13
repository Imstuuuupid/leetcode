package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 * 最大二叉树
 * 
 * @author xzx
 * @date 2020/12/13 11/50
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    private TreeNode build(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = findMax(nums, begin, end);
        TreeNode root = new TreeNode(nums[index]);

        root.left = build(nums, begin, index - 1);
        root.right = build(nums, index + 1, end);
        return root;
    }

}
