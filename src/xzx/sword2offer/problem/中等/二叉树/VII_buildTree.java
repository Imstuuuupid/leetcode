package xzx.sword2offer.problem.中等.二叉树;

import xzx.structure.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树：
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */

public class VII_buildTree {


//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        po = preorder;
//        for(int i = 0; i < inorder.length; i++)
//            dic.put(inorder[i], i);
//        return recur(0, 0, inorder.length - 1);
//    }


//    /**
//     * 创建hashmap是用来存储中序遍历，pro用来存储前序遍历
//     * 都是为了方便传递参数
//     * <p>
//     * 另外：
//     * 中序遍历用
//     */

    private Map<Integer, Integer> inTraverse = new HashMap<>();
    private int[] preTraverse;

    /**
     * 思路：
     * 前遍历顺序为   中、左、右
     * 中遍历顺序为   左、中、右
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preTraverse = preorder;
        for (int i = 0; i < inorder.length - 1; i++) {
            inTraverse.put(inorder[i], i);
        }
        //初始递归 中序开始   根节点在前序的位置，中序左边界 ， 中序右边界
        return stepBuild(0, 0, inorder.length - 1);
    }

    /**
     * 前遍历得到的第一个必为根节点，记为root
     * 然后由中遍历根据数获得下标，记为i
     * 有了root就要给左右节点赋值，下面进行递归
     * <p>
     * 递归的判断条件就是 左子树遍历边界 < 右子树遍历边界
     * <p>
     * 左子树：
     * 根据前序遍历，中左右，在前序遍历里面获得的 根节点+1 即为左子树根节点
     * 遍历左子树的时候左边界不变，右边界变为 i-1
     * 右子树：
     * 根据中序遍历得到 根节点 下标，减去左边界得到左子树长度 ，再加上前序遍历的根节点下标+1
     * 即(i-inLeft + preRoot +1)
     * 遍历右子树的时候右边界不变，左边界变为i+1
     *
     * @param preRoot 前序遍历的根节点下标
     * @param inLeft  中序遍历的左子树起始点
     * @param inRight 中序遍历的右子树起始点
     * @return 返回子树的根节点
     */
    TreeNode stepBuild(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preTraverse[preRoot]);
        int i = inTraverse.get(preTraverse[preRoot]);
        root.left = stepBuild(preRoot + 1, inLeft, i - 1);
        root.right = stepBuild(i - inLeft + preRoot + 1, i + 1, inRight);
        return root;

    }

    //    TreeNode recur(int pre_root, int in_left, int in_right) {
//        if(in_left > in_right) return null;
//        TreeNode root = new TreeNode(po[pre_root]);
//        int i = dic.get(po[pre_root]);
//        root.left = recur(pre_root + 1, in_left, i - 1);
//        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
//        return root;
//    }
}
