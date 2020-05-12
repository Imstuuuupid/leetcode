package xzx.剑指offer;

import xzx.剑指offer.题目.中等.XII_pathInMatrix;

public class mainTest {
    /**
     * 测试：
     *      双栈做队列
     * @param args
     */
//    public static void main(String[] args) {
//
//        CQueue obj = new CQueue();
//        obj.appendTail(1);
//        obj.appendTail(2);
//        obj.appendTail(3);
//        obj.appendTail(4);
//        int param_1 = obj.deleteHead();
//        obj.appendTail(5);
//        int param_2 = obj.deleteHead();
//        obj.appendTail(6);
//        int param_3 = obj.deleteHead();
//        int param_4 = obj.deleteHead();
//        int param_5 = obj.deleteHead();
//        int param_6 = obj.deleteHead();
//        System.out.println(param_1);
//        System.out.println(param_2);
//        System.out.println(param_3);
//        System.out.println(param_4);
//        System.out.println(param_5);
//        System.out.println(param_6);
//
//    }

    /**
     * 测试：
     *      二维数组中的查找
     * @param args
     */
//    public static void main(String[] args) {
//
//        int [][]martix={
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
//        findIn2dArray findIn2dArray=new findIn2dArray();
//
//        System.out.println(findIn2dArray.findNumberIn2DArray(martix,9));
//    }

    /**
     *
     * 测试：
     *      台阶方式问题
     * @param args
     */
//    public static void main(String[] args) {
//        numWays numWays=new numWays();
//        int a=numWays.numWay(7);
//        System.out.println(a);
//    }

    /**
     * 测试：
     *      矩阵路径检测
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String words="ABCCED";
        XII_pathInMatrix pim=new XII_pathInMatrix();
        System.out.println(pim.exist(board,words));
    }

}
