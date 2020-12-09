package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.*;

/**
 * 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *  
 *
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xzx
 * @date 2020/12/09 11/23
 */
public class DelNodes {
    List<TreeNode> res = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        for (int a : to_delete) {
            set.add(a);
        }
        if (!set.contains(root.val)) {
            res.add(root);
        }
        del(null, root);
        return res;
    }

    private void del(TreeNode parent, TreeNode cur) {
        if (cur == null) {
            return;
        }
        del(cur, cur.left);
        del(cur, cur.right);
        if (set.contains(cur.val)) {
            if (cur.left != null) {
                res.add(cur.left);
            }
            if (cur.right != null) {
                res.add(cur.right);
            }
            if (parent != null) {
                if (parent.left == cur) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }
}
