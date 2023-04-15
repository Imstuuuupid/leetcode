package xzx.tree.exams;

import xzx.tree.Node;

/**
 * 二叉树最近的公共节点
 * @author zjy
 * @date 2021/03/21 11/37
 */
public class PublicParent {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right= new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println(head.toString());
    }

    private static void parent(Node head , int a , int b){
        if (head != null){


        }
    }
}
