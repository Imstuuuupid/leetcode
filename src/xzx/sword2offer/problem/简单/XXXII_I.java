package xzx.sword2offer.problem.简单;

import xzx.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目:
 * 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 */
public class XXXII_I {
    /**
     * 思路：
     * 因为是按层输出，所以采用BFS的算法，结合队列先进先出的特点
     * 流程如下：
     * 输入头结点，头结点出队列，把值存入数组
     * 然后判断头结点左右孩子是否为空，不为空分别把左右孩子节点入队列
     * 然后依次重复，直到队列为空
     *
     * 这个思路简直绝了！！！！！！
     * 大佬nb！！！！！
     * @param root
     * @return
     */

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            result.add(node.val);
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


}
