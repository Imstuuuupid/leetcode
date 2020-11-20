package xzx.tree.normal;

import xzx.sword2offer.problem.structure.ListNode;
import xzx.sword2offer.problem.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: xzx
 * @Date: 2020/10/27 9:13 下午
 **/
public class SpecificDepthNodeLists {
    public static void main(String[] args) {

    }

    /**
     * 队列是解决层级遍历数的常用方法
     * 需要注意的是控制每一层的大小，以此作为层级遍历控制
     * @Author: xzx
     * @Date: 2020/10/27 9:54 下午
     * @Param: [tree]
     * @Return: xzx.sword2offer.problem.structure.ListNode[]
     **/
    public ListNode[] listOfDepth(TreeNode tree){
        if(tree == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> res = new ArrayList<>();
        queue.offer(tree);
        ListNode temp;
        while (!queue.isEmpty()) {
            Integer floorSize = queue.size();
            ListNode head = new ListNode(-1);
            temp = head;
            for(int i = 0 ; i < floorSize ; i++){
                TreeNode poll = queue.poll();
                temp.next = new ListNode(poll.val);
                temp = temp.next;
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(head.next);
        }

        return res.toArray(new ListNode[res.size()]);
    }
}
