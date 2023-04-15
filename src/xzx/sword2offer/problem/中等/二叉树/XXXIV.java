package xzx.sword2offer.problem.中等.二叉树;

import xzx.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class XXXIV {

    /**
     * 思路：
     * 回溯算法
     * 编写一个递归函数，调用，
     *
     *
     * @param root
     * @param sum
     * @return
     */

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        //到达底部，且这条路径和为sum
        if (sum == 0 && root.left == null && root.right == null) {
            // 这是错误的操作，这里将path对象放入了res内部，那么path内部改变时，res里面的path也会改变
            // res.add(path)
            // 正确的做法是浅拷贝一个path对象然后放入res中
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //这里不是很清楚，只知道是回溯
        //根据网友的理解，sum是每一次调用时都有不同的值所以不用管，但是path确是所有调用同时使用的，
        //所以在使用完之后需要返回原本的状态，这样理解的话当程序执行完毕path应该为空
        path.removeLast();

    }
}
