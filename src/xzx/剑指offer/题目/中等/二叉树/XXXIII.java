package xzx.剑指offer.题目.中等.二叉树;

/**
 * 题目：
 * 二叉树搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 */
public class XXXIII {
    /**
     * 思路：
     * 后序遍历：左子树  右子树  根节点
     * <p>
     * 二叉搜索树： 左< 右< 根
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return lrr(postorder, 0, postorder.length - 1);
    }

    /**
     * 思路：
     * 给一个数组，数组最左端是根节点
     * <p>
     * 记p从begin开始++，遍历到p所指数大于根节点
     * <p>
     * 左子树遍历完成，记录，然后开始遍历右子树++
     * <p>
     * 当p所指数不大于根节点，说明p指到了根节点
     * <p>
     * 判断p所指是不是end  同时开启左右子树递归判断
     *
     * @param po    序列数组
     * @param begin 数组最左
     * @param end   数组最右
     * @return
     */
    public boolean lrr(int[] po, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int p = begin;
        while (po[p] < po[end]) {
            p++;
        }
        //跳出循环的时候p到了右子树,记录p的位置m，m-1是左子树，m是右子树开头
        int m = p;
        while (po[p] > po[end]) {
            p++;
        }
        //p跳出了循环，到了根节点，判断p是不是end，如果是，没问题，不是就错了
        //同时开启左右子树的递归遍历
        // ※右子树在开启递归的时候，要排除根节点
        return p == end && lrr(po, begin, m - 1) && lrr(po, m, end);
    }

}
