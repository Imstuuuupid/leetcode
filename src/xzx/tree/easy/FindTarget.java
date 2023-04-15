package xzx.tree.easy;

import xzx.structure.TreeNode;

import java.util.HashSet;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/03 16/22
 */
public class FindTarget {
    /**
     * 在树的每个节点上都遍历其左右子树查找是否有符合条件的节点，
     * 每一个节点都要加进Hashset 中 。
     *
     * @author xzx
     * @date 2020/12/03 16:45
     * @param root
     * @param k
     * @return boolean
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root,k,set);
    }

    public boolean find(TreeNode root , int k , HashSet<Integer> hashSet) {
        if(root == null) {
            return false;
        }
        if(hashSet.contains(k-root.val)) {
            return true;
        }
        hashSet.add(root.val);
        return find(root.left,k,hashSet) || find(root.right,k,hashSet);
    }
}
