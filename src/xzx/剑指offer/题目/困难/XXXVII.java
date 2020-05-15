package xzx.剑指offer.题目.困难;

import xzx.剑指offer.题目.结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * // Your Codec object will be instantiated and called as such:
 * // Codec codec = new Codec();
 * // codec.deserialize(codec.serialize(root));
 * <p>
 * 注意题目调用函数的方式，对树序列化之后紧接着反序列化
 * 不用太过在意序列化的形式问题，只要反序列化的时候能将这个序列复原为原树就好了。
 */
public class XXXVII {
    // Encodes a tree to a single string.

    /**
     * 思路：
     * 序列化就采用单向队列，结点，左子树，右子树
     *
     * @param root
     * @return
     */

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer res = new StringBuffer();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                res.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        XXXVII s = new XXXVII();
        System.out.println(s.serialize(root));


    }

    /**
     * 思路：
     * 既然序列化是按层次遍历，且保存了序列
     * 那么再按层次遍历一遍，将序列作为参照，给树重塑就好了。
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
        {
            return null;
        }
        String[] tree=data.split(",");
        //Integer.parseInt()这个函数可以将String类型的数转换为带符号的十进制Integer
        TreeNode root=new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{
            add(root)
        }};
        int p=1;
        while (!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(!"null".equals(tree[p]))
            {
                node.left=new TreeNode(Integer.parseInt(tree[p]));
                queue.add(node.left);
            }
            p++;
            if(!"null".equals(tree[p]))
            {
                node.right=new TreeNode(Integer.parseInt(tree[p]));
                queue.add(node.right);
            }
            p++;
        }
        return root;

    }
}
