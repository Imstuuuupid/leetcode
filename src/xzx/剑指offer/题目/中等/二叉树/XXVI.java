package xzx.剑指offer.题目.中等.二叉树;

import xzx.剑指offer.题目.结构.TreeNode;

/**
 * 题目：
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
public class XXVI {
    /**
     * 思路：
     * A、B不能为空
     * 调用比较函数如果成功就返回true，失败就转换比较A的左右子树，再失败就返回false
     * <p>
     * 比较函数，先比较A.val和B.val，然后比较左右节点，失败返回false
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        //这里是比较A、B，如果不成，就换A左右子树，调用自身，再进行一次compare
        if (compare(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

    }

    public boolean compare(TreeNode A, TreeNode B) {
        //B的子树为空，前面都比较成功了，返回true
        if (B == null) {
            return true;
        }
        //A不能为空，A为空就不能匹配上B
        if (A == null) {
            return false;
        }
        //迷幻操作开始，这个节点相同，开始递归左右节点
        //这个递归到最后会循环到B==null上，然后就返回成功了，迷！！！
        if (A.val == B.val) {
            return compare(A.left, B.left) && compare(A.right, B.right);
        } else {
            return false;
        }
    }
}
