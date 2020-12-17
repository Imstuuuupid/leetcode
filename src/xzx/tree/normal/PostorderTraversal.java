package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 * 
 * @author xzx
 * @date 2020/12/05 13/59
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                res.add(temp.val);
            } else {
                continue;
            }
            stack.push(temp.left);
            stack.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        PreorderTraversal ex = new PreorderTraversal();
        List<Integer> integers = ex.preorderTraversal(root);
        System.out.println(integers);
        InorderTraversal in = new InorderTraversal();
        List<Integer> integers1 = in.inorderTraversal(root);
        System.out.println(integers1);
        PostorderTraversal po = new PostorderTraversal();
        integers = po.postOrderTraversal(root);
        System.out.println(integers);
    }
}
