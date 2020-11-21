package xzx.tree.easy;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/11/21 15/32
 */
public class LevelOrderBottom {
    /**
     * 考虑到这个顺序
     * 就像是从上至下层次遍历之后被压入堆栈，然后出栈形成的列表
     * 先实现从上至下的层次遍历，然后将其压入堆栈，最后取出
     *
     * 优化：
     * 从上至下遍历，把遍历得到的结果加入头队列
     * @author xzx
     * @date 2020/11/21 15:36
     * @param root
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> temp = null;
        LinkedList<List<Integer>> res = new LinkedList<>();
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.addFirst(temp);
        }
        return res;
    }

    private List<List<Integer>> first(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> temp = null;
        Stack stack = new Stack();
        List<List<Integer>> res = new LinkedList<>();
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            res.add((List<Integer>)stack.pop());
        }
        return res;
    }
}
