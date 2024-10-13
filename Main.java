import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //player name
        System.out.println("Let's play Tic Tac Toe!");

        System.out.print("Player 1, what is your name? ");
        String player_1 = sc.nextLine();

        System.out.print("Player 2, what is your name? ");
        String player_2 = sc.nextLine();

        // board game
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        boolean isp1 = true;

        boolean gameEnd = false;

        while(!gameEnd) {
            Board_Game(board);

            char symbol = ' ';
            if (isp1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            if (isp1) {
                System.out.println(player_1 + " turn x: ");
            } else {
                System.out.println(player_2 + " turn o: ");
            }

            int row = 0;
            int column = 0;

            while (true) {
                System.out.print("Enter a row (0, 1 or 2): ");
                row = sc.nextInt();

                System.out.print("Enter a column (0, 1 or 2): ");
                column = sc.nextInt();

                if (row < 0 || column < 0 || row > 2 || column > 2) {
                    System.out.println("Are you idiots take a real board index");
                } else if (board[row][column] != '-') {
                    System.out.println("Someone already has this index");
                } else {
                    break;
                }
            }

            board[row][column] = symbol;

            if (hasWon(board) == 'x') {
                System.out.println(player_1 + " has won!");
                gameEnd = true;
            } else if (hasWon(board) == 'o'){
                System.out.println(player_2 + " has won!");
                gameEnd = true;
            } else{
                if (hasTied(board)) {
                    System.out.println("its a tie!");
                    gameEnd = true;
                } else {
                    isp1 = !isp1;
                }
            }
        }

        Board_Game(board);
    }

    public static void Board_Game(char[][] board){
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        for(int i = 0; i < 3; i++) {
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            }
        }

        for(int i = 0; i < 3; i++) {
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                return board[0][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
                return board[2][0];
            }
        }

        return '-';
    }

    public static boolean hasTied (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}