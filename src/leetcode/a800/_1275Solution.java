package leetcode.a800;

/**
 * 判断井字棋的获胜者
 * {easy}
 */
public class _1275Solution {
    public String tictactoe(int[][] moves) {

        char grid[][] = new char[3][3];
        int i = 0;
        for (int[] move : moves) {
            grid[move[0]][move[1]] = i == 0 ? 'X' : 'O';
            i ^= 1;
        }
        if ((grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') ||
                (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X'))
            return "A";
        if ((grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') ||
                (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O'))
            return "B";

        int countA = 0;
        int countB = 0;
        boolean iffilled = true;
        for (int j = 0; j < 3; j++) {
            boolean ifallA = true;
            boolean ifallB = true;
            boolean ifallArow = true;
            boolean ifallBrow = true;
            for (int k = 0; k < 3; k++) {
                if (grid[j][k] != 'X' && grid[j][k] != 'O')
                    iffilled = false;
                if (grid[j][k] != 'X')
                    ifallA = false;
                if (grid[j][k] != 'O')
                    ifallB = false;
                if (grid[k][j] != 'X')
                    ifallArow = false;
                if (grid[k][j] != 'O')
                    ifallBrow = false;

            }
            if (ifallA)
                countA++;
            if (ifallB)
                countB++;
            if (ifallArow)
                countA++;
            if (ifallBrow)
                countB++;
        }

        if (countA > 0 && countB > 0) {
            return "Draw";
        }
        if (countA > 0)
            return "A";
        if (countB > 0)
            return "B";
        if (iffilled)
            return "Draw";
        return "Pending";

    }
}
