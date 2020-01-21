package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _51Solution {

    public List<List<String>> solveNQueen(int n){
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res){
        if(colIndex == board.length){
            res.add(construct(board));
            return;
        }

        for(int i=0;i<board.length;i++){
            if(validate(board,i,colIndex)){
                board[i][colIndex] = 'Q';
                dfs(board, colIndex+1,res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='Q'&&(x==j||x+j==y+i||x+y==i+j))
                    return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s= new String(board[i]);
            res.add(s);
        }

        return res;
    }


}
