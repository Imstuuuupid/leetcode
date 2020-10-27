package xzx.sword2offer.problem.中等;

import xzx.sword2offer.problem.中等.结构.Node;

/**
 * 题目：
 * 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 *  
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 *  
 * <p>
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。
 * 当转化完成以后，树中节点的左指针需要指向前驱，
 * 树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class XXXVI {
    /**
     * 思路：
     * 中序遍历一遍，放入map，然后连接
     * <p>
     * 思路没人问题，但是可以优化
     * 中序遍历之后是顺序数组的结构，
     * 那么可以直接调整数的左右节点指向，使得结构符合要求
     *
     * @param root
     * @return
     */
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        //遍历完之后，pre在尾，head在头，首尾相接
        pre.right = head;
        //这里弥补了第一次执行的空缺
        head.left = pre;
        return head;

    }

    public void inorder(Node current) {
        if (current == null) {
            return;
        }
        inorder(current.left);
        //如果是第一次，要想办法把head和pre插进去，保证后面的递归能正常执行
        if (pre != null) {
            pre.right = current;
        } else {
            head = current;
        }
        //第一次执行时，这里left指向了null
        current.left = pre;
        pre = current;
        inorder(current.right);

    }
}

