package xzx.剑指offer.题目.简单;

import xzx.剑指offer.题目.结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：
 * 从上到下打印二叉树-2
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class XXXII_II {
    /**
     * 思路：
     * 每一次出队列的时候，把它出完不就好了？？？？？
     *
     * 憨憨行为
     *
     * 还去看别人的解答
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result= new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty())
        {
            //每一次循环产生新的数组，就可以一行一个数组输出了
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=queue.size();i>0;i--)
            {
                TreeNode node=queue.poll();
                temp.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

}
