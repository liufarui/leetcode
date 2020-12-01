package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/10 9:45
 * 
 * 79. 单词搜索
 * 
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 解题思路：
 * 回溯；
 * 首先找到整个数组里面匹配第一个字符的格子，然后往下（左右上下）继续寻找；
 * 注意边界值考虑；
 * 如果开始指针和字符串长度相同，则返回true，只要有一次true，就不需要继续往下遍历了；
 * 之前的时候放了一个set保存已经使用的值，发现时间超出了限制；
 * 然后使用了同大小的bool类型数组，解决了此问题。
 */
public class _79_exist {
    public boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        if (cs.length == 0) {
            return true;
        }
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == cs[0] && exist(board, cs, 1, flag, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] cs, int start, boolean[][] flag, int X, int Y) {
        if (start == cs.length) {
            return true;
        }
        flag[X][Y] = true;
        if (X + 1 < board.length && !flag[X + 1][Y] && board[X + 1][Y] == cs[start] && exist(board, cs, start + 1, flag, X + 1, Y)) {
            return true;
        }
        if (Y + 1 < board[0].length && !flag[X][Y + 1] && board[X][Y + 1] == cs[start] && exist(board, cs, start + 1, flag, X, Y + 1)) {
            return true;
        }
        if (X > 0 && !flag[X - 1][Y] && board[X - 1][Y] == cs[start] && exist(board, cs, start + 1, flag, X - 1, Y)) {
            return true;
        }
        if (Y > 0 && !flag[X][Y - 1] && board[X][Y - 1] == cs[start] && exist(board, cs, start + 1, flag, X, Y - 1)) {
            return true;
        }
        flag[X][Y] = false;

        return false;
    }
}
