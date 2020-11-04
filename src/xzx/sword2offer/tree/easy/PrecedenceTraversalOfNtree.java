package xzx.sword2offer.tree.easy;

import xzx.sword2offer.tree.structure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 ：
 *         1
 *      /  |  \
 *     3   2   4
 *    / \
 *   5   6
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @Author: xzx
 * @Date: 2020/10/29 9:18 上午
 **/
public class PrecedenceTraversalOfNtree {
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public List<Integer> traversal(Node root , List<Integer> res) {
        if(root == null) {
            return res;
        }
        res.add(root.val);
        for (int i = 0 ; i < root.children.size() ; i++) {
            traversal(root.children.get(i),res);
        }
        return res;
    }
}
