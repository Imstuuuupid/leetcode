package xzx.剑指offer.题目.简单;

import xzx.剑指offer.题目.结构.TreeNode;

/**
 * 题目：
 * 对称二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class XXVIII {
    /**
     * 思路：
     * L.left=R.right
     * L.right=R.left
     * 这是对称的标志
     * 所以再写一个函数，用来递归判断
     *
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return judge(root.left,root.right);

    }

    /**
     * 反正最后递归都会指到最后一个的子树，那就不用判断子树是不是空
     * 直接判断被指到的节点是不是为空就行了
     * @param le
     * @param ri
     * @return
     */
    public boolean judge(TreeNode le,TreeNode ri)
    {
        if(le==null&&ri==null)
        {
            return true;
        }
        //上面就判断了同时为null，所以这里不可能同时为空，任何一个条件成立，都不是对称树
        if(le==null||ri==null||le.val!=ri.val)
        {
            return false;
        }
        //这里直接把对称点带入比较，成功会返回true
        return judge(le.left,ri.right)&&judge(le.right,ri.left);

    }
}
