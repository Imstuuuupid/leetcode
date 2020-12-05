package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 * @author xzx
 * @date 2020/12/03 16/56
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }

    public List<Integer> preorderIteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }
}
