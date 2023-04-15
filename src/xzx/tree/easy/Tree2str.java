package xzx.tree.easy;

import xzx.structure.TreeNode;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/11/21 14/08
 */
public class Tree2str {
    /**
     * 按照题目给出的输出，这是个先序遍历
     * 根节点没有括号
     * 左右叶节点都用括号包裹，
     * 如果左节点为空-》（）
     * 如果右节点为空-》''
     * @author xzx
     * @date 2020/11/21 14:17
     * @param t 
     * @return java.lang.String
     */
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        withBracket(t,res);
        return res.toString();
    }

    private void withBracket(TreeNode t , StringBuilder res) {
        if (t != null) {
            res.append(t.val);
            if (t.left != null || t.right != null) {
                res.append("(");
                withBracket(t.left, res);
                res.append(")");
                if (t.right != null) {
                    res.append("(");
                    withBracket(t.right, res);
                    res.append(")");
                }
            }
        }
    }


    private String firstSolution(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        if (t.left != null && t.right == null) {
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")";
        }
        if (t.left == null && t.right != null) {
            return String.valueOf(t.val) + "()" + "(" + tree2str(t.right) + ")";
        }
        return String.valueOf(t.val) + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
