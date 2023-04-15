package xzx.tree.easy;

import xzx.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 * 
 * @author xzx
 * @date 2020/12/09 11/16
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
