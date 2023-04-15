package xzx.sword2offer.problem.简单;

import xzx.structure.TreeNode;

import java.util.*;

/**
 * 题目：
 * 从上到下打印二叉树-3
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class XXXII_III {
    /**
     * 思路：
     * 同二，但是队列变为双端，可头插值，尾插值。。。
     * md！
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // 偶数层 -> 队列头部
                if (result.size() % 2 == 0) {
                    temp.addLast(node.val);
                }
                // 奇数层 -> 队列尾部
                else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = root;
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
        p = p.right;
        p.right = new TreeNode(7);
        p.left = new TreeNode(15);
        XXXII_III s = new XXXII_III();
        System.out.println(s.levelOrder(root));
    }
}
