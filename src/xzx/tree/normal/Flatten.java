package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

/**
 *
 * @author xzx
 * @date 2020/12/01 15/59
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        while (root.right != null) {
            root = root.right;
        }

        root.right = right;

    }
}
