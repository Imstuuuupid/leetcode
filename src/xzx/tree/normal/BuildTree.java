package xzx.tree.normal;

import xzx.sword2offer.problem.structure.TreeNode;

import java.util.Arrays;

/**
 *
 * @author xzx
 * @date 2020/12/14 19/52
 */
public class BuildTree {

    /**
     * 根据前序和中序遍历，反向构造树
     * @author xzx
     * @date 2020/12/14 20:24
     * @param preorder
     * @param inorder
     * @return xzx.sword2offer.problem.structure.TreeNode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int temp = preorder[0];
        TreeNode root = new TreeNode(temp);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == temp) {
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
            Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = Arrays.copyOfRange(a, 2, 4);
        Arrays.stream(b).forEach(System.out::println);
    }

    /**
     * 根据中序和后序遍历反向构造
     * @author xzx
     * @date 2020/12/14 20:31
     * @param inorder
     * @param postorder
     * @return xzx.sword2offer.problem.structure.TreeNode
     */
    int[] inorder, postorder;
    public TreeNode buildTreeInAndPost(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return null;
    }


}
