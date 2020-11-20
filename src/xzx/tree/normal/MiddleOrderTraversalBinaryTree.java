package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: xzx
 * @Date: 2020/10/30 10:14 上午
 **/
public class MiddleOrderTraversalBinaryTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return traversal(root , res);
    }

    public List<Integer> traversal (TreeNode root , List<Integer> res) {
        if(root == null){
            return new ArrayList<>();
        }
        traversal(root.left , res);
        res.add(root.val);
        traversal(root.right, res);
        return res;
    }
}
