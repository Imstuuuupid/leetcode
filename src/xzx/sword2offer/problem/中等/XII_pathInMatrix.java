package xzx.sword2offer.problem.中等;

/**
 * 题目：矩阵中的路径
 *
 *      请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 *      如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *      例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 *      [["a","b","c","e"],
 *      ["s","f","c","s"],
 *      ["a","d","e","e"]]
 *
 *      但矩阵中不包含字符串“abfb”的路径，
 *      因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子
 *
 *
 *
 *
 */
public class XII_pathInMatrix {
    /**
     * 思路：
     *          深度优先算法DFS+剪枝
     *          使用递归，判断条件为匹配到word.length个字符，
     *          因为程序只需要判断字符是否存在所以不需要对这些字符进行存储
     *
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                //这里是采用stepFind的递归返回false或者true来判断，
                //只要找到了一条路径就返回true
                //如果没有找到，即此循环遍历了矩阵，但没有结果返回到这一层函数
                if(stepFind(board,words,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS算法顺序是下上右左，将不符合条件的路径剪枝
     *
     * 一次深度搜索之后未成功会进行下一次深度搜索，
     * 但match在上层循环调用时默认为0，故都是从第一个字符开始匹配
     * @param board     字符矩阵
     * @param words     将原string转为char[]类型，便于判断
     * @param i         控制行
     * @param j         控制列
     * @param match     控制匹配个数
     * @return
     */
    public boolean stepFind(char[][] board,char[] words,int i,int j,int match)
    {
        //下标越界、字符不匹配的部分剪掉
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=words[match])
        {
            return false;
        }
        //下面的代码执行前提是，匹配到了
        char temp=board[i][j];
        //匹配到了全部字符。假设是hello，则match匹配历程是0,1,2,3,4 共五个，length-1
        if(match==words.length-1)
        {
            return true;
        }
        //将走过的路程标记，避免重复
        board[i][j]='/';
        boolean res=stepFind(board,words,i+1,j,match+1)||
                stepFind(board,words,i-1,j,match+1)||
                stepFind(board,words,i,j+1,match+1)||
                stepFind(board,words,i,j-1,match+1);
        //不管返回true和false都要恢复原值，为下一次深度搜索还原矩阵
        board[i][j]=temp;
        return res;
    }
}
