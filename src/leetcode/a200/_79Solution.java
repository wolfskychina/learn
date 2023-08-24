package leetcode.a200;

public class _79Solution {


    public boolean exist = false;
    int [] diX ={-1,1,0,0};
    int [] diY ={0,0,1,-1};

    public boolean exist(char[][] board, String word) {

        if(board ==null ||board.length == 0||board[0].length ==0||word ==null) return false;

        int m =board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(exist) return exist;
                search(i,j,board,word,0);
            }
        }

        return exist;
    }

    public void search(int x, int y, char[][] board, String word, int k){

        if(exist) return;

        if(board[x][y] == word.charAt(k)){

            if(k+1==word.length()) {
                exist = true;
                return ;
            }

            // match,search the next four directions.
            board[x][y] = '.';

            for(int r=0;r<4;r++){

                int xx = x+diX[r];
                int yy = y+diY[r];

                if(xx>=0&&xx<board.length&&yy>=0&&yy<board[0].length){
                    search(xx,yy,board,word,k+1);
                }
            }
            board[x][y] = word.charAt(k);
        }

        return;
    }

    public static void main(String[] args){

        _79Solution so = new _79Solution();
        char[][] board = {{'a','b'}};
        System.out.println(so.exist(board, "ab"));
    }
}
