import java.util.*;
// NOTES FOR TOMORROW
// MAKE WORKING METHOD TO SEARCH FOR VALID MOVES IN ARRAY LIST
// MAKE SYSTEM FOR REPLAYS
public class TicTacToe {
    // Static variables for the TicTacToe class, effectively configuration options
    // Use these instead of hard-coding ' ', 'X', and 'O' as symbols for the game
    // In other words, changing one of these variables should change the program
    // to use that new symbol instead without breaking anything
    // Do NOT add additional static variables to the class!
    static char emptySpaceSymbol = ' ';
    static char playerOneSymbol = 'X';
    static char playerTwoSymbol = 'O';

    public static void main(String[] args) {
        // This is where the main menu system of the program will be written.
        // Hint: Since many of the game runner methods take in an array of player names,
        // you'll probably need to collect names here.
        Scanner sc = new Scanner(System.in);
        int i = 0;
        ArrayList<char[][]> pastGames = new ArrayList<char[][]>();
        String[] playerNames = new String[2];
        // Loop that gives multiple options for player
        while (i < 1) {
            System.out.println();
            System.out.println("Welcome to game of Tic Tac Toe, choose one of the following options from below:");
            System.out.println();
            System.out.println("1. Single Player");
            System.out.println("2. Two Player");
            System.out.println("D. Display last match");
            System.out.println("Q. Quit");
            String select = sc.nextLine();
            if (select.equals("1")) {
                playerNames[1] = "Computer";
                System.out.print("Please enter Player name: ");
                playerNames[0] = sc.nextLine();
                pastGames = runOnePlayerGame(playerNames);
            } else if (select.equals("2")) {
                System.out.print("Please enter Player 1 name: ");
                playerNames[0] = sc.nextLine();
                System.out.print("Please enter Player 2 name: ");
                playerNames[1] = sc.nextLine();
                pastGames = runTwoPlayerGame(playerNames);
            } else if (select.equals("D")) {
                if (pastGames.isEmpty()) {
                    System.out.println("No match found.");
                }
                else {
                    runGameHistory(playerNames, pastGames);
                }
            } else if (select.equals("Q")) {
                System.out.print("Thanks for playing. Hope you had fun!");
                i = 1;
            } else {
                System.out.print("That is not one of the 4 options, please try again: ");
            }
        }
    }

    // Given a state, return a String which is the textual representation of the tic-tac-toe board at that state.
    private static String displayGameFromState(char[][] state) {
        // Hint: Make use of the newline character \n to get everything into one String
        // It would be best practice to do this with a loop, but since we hardcode the game to only use 3x3 boards
        // it's fine to do this without one.
        String board = "";
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (j == 0 || j == 1) {
                    board += (state[i][j] + " | ");
                }
                else {
                    board += (state[i][j] + "  ");
                }
            }
            if (i < 2) {
                board += "\n" + "----------" + "\n";
            }
        }

        return board;
    }

    // Returns the state of a game that has just started.
    // This method is implemented for you. You can use it as an example of how to utilize the static class variables.
    // As you can see, you can use it just like any other variable, since it is instantiated and given a value already.
    private static char[][] getInitialGameState() {
        return new char[][]{{emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                            {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                            {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol}};
    }

    // Given the player names, run the two-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runTwoPlayerGame(String[] playerNames) {
        ArrayList<char[][]> twoPlrGame = new ArrayList<>();
        int i = 0;
        int turn;
        System.out.println("Tossing a coin to decide who goes first!!!");
        double plr1Gen = Math.random();
        if (plr1Gen > 0.5) {
            System.out.println(playerNames[1] + " gets to go first.");
            turn = 1;
        }
        else {
            System.out.println(playerNames[0] + " gets to go first.");
            turn = 0;
        }
        char[][] gameState = new char[3][3];
        gameState = getInitialGameState().clone();
            while (i == 0) {
                System.out.println(displayGameFromState(gameState));
                twoPlrGame.add(copyGameState(gameState));
                if (checkDraw(gameState)) {
                    System.out.println("It's a draw!");
                    i = 1;
                } else if (checkWin(gameState)) {
                    if (turn == 0) {
                        System.out.println(playerNames[1] + " wins!");
                    } else {
                        System.out.println(playerNames[0] + " wins!");
                    }
                    i = 1;
                } else if (turn == 0) {
                    gameState = runPlayerMove(playerNames[0], playerOneSymbol, gameState);
                    turn = 1;
                } else {
                    gameState = runPlayerMove(playerNames[1], playerTwoSymbol, gameState);
                    turn = 0;
                }
            }

        return twoPlrGame;
    }

    // Given the player names (where player two is "Computer"),
    // Run the one-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runOnePlayerGame(String[] playerNames) {

        ArrayList<char[][]> onePlrGame = new ArrayList<>();
        int i = 0;
        int turn;
        System.out.println("Tossing a coin to decide who goes first!!!");
        double plr1Gen = Math.random();
        if (plr1Gen > 0.5) {
            System.out.println(playerNames[1] + " gets to go first.");
            turn = 1;
        }
        else {
            System.out.println(playerNames[0] + " gets to go first.");
            turn = 0;
        }
        char[][] gameState = new char[3][3];
        gameState = getInitialGameState().clone();
            while (i == 0) {
                System.out.println(displayGameFromState(gameState));
                onePlrGame.add(copyGameState(gameState));
                if (checkDraw(gameState)) {
                    System.out.println("It's a draw!");
                    i = 1;
                } else if (checkWin(gameState)) {
                    if (turn == 0) {
                        System.out.println(playerNames[1] + " wins!");
                    } else {
                        System.out.println(playerNames[0] + " wins!");
                    }
                    i = 1;
                } else if (turn == 0) {
                    gameState = runPlayerMove(playerNames[0], playerOneSymbol, gameState);
                    turn = 1;
                } else {
                    System.out.println("Computer's turn: ");
                    gameState = getCPUMove(gameState);
                    turn = 0;
                }
            }


        return onePlrGame;
    }

    private static char[][] copyGameState(char[][] gameState) {
        // Method that copies a given gameState
        // Purpose is to avoid gameState being affected while being placed in ArrayList
        char[][] gameStateCopy = new char[gameState.length][gameState[0].length];
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[0].length; j++) {
                gameStateCopy[i][j] = gameState[i][j];
            }
        }
        return gameStateCopy;
    }

    // Repeatedly prompts player for move in current state, returning new state after their valid move is made
    private static char[][] runPlayerMove(String playerName, char playerSymbol, char[][] currentState) {

        int i = 0;
        while (i == 0) {
            int[] plrMove = getInBoundsPlayerMove(playerName);
            if (plrMove[0] > 2 || plrMove[0] < 0 || plrMove[1] > 2 || plrMove[1] < 0) {
                System.out.println("That row or column is out of bounds. Try again.");
            }
            else if (checkValidMove(plrMove, currentState)) {
                currentState[plrMove[0]][plrMove[1]] = playerSymbol;
                i = 1;
            }
            else {
                System.out.println("That space is already taken. Try again");
            }
        }
        return currentState;
    }

    // Repeatedly prompts player for move. Returns [row, column] of their desired move such that row & column are on
    // the 3x3 board, but does not check for availability of that space.
    private static int[] getInBoundsPlayerMove(String playerName) {
        Scanner sc = new Scanner(System.in);
        int[] plrMove = new int[2];
        System.out.println(playerName + "'s turn:");
        System.out.print(playerName + " enter row: ");
        plrMove[0] = sc.nextInt();
        System.out.print(playerName + " enter column: ");
        plrMove[1] = sc.nextInt();
        return plrMove;
    }

    // Given a [row, col] move, return true if a space is unclaimed.
    // Doesn't need to check whether move is within bounds of the board.
    private static boolean checkValidMove(int[] move, char[][] state) {
        // Checks if a certain move is valid
        if (state[move[0]][move[1]] == emptySpaceSymbol) {
            return true;
        } else {
            return false;
        }
    }

    // Given a [row, col] move, the symbol to add, and a game state,
    // Return a NEW array (do NOT modify the argument currentState) with the new game state
    private static char[][] makeMove(int[] move, char symbol, char[][] currentState) {
        // Hint: Make use of Arrays.copyOf() somehow to copy a 1D array easily
        // You may need to use it multiple times for a 1D array
        char[][] movedState = new char[3][3];
        for (int i = 0; i < currentState.length; i++) {
            movedState[i] = Arrays.copyOf(currentState[i], 3);
        }
        movedState[move[0]][move[1]] = symbol;
        return movedState;
    }

    // Given a state, return true if some player has won in that state
    private static boolean checkWin(char[][] state) {
        // Hint: no need to check if player one has won and if player two has won in separate steps,
        // you can just check if the same symbol occurs three times in any row, col, or diagonal (except empty space symbol)
        // But either implementation is valid: do whatever makes most sense to you.

        // Horizontals
        // Verticals
        // Diagonals
        if (state[0][0] == state[0][1] && state[0][1] == state[0][2] && state[0][0] != emptySpaceSymbol) {
            return true;
        } else if (state[1][0] == state[1][1]  && state[1][1] == state[1][2] && state[1][0] != emptySpaceSymbol) {
            return true;
        } else if (state[2][0] == state[2][1] && state[2][1] == state[2][2] && state[2][0] != emptySpaceSymbol) {
            return true;
        } else if (state[0][0] == state[1][0] && state[1][0] == state[2][0] && state[0][0] != emptySpaceSymbol) {
            return true;
        } else if (state[0][1] == state[1][1] && state[1][1] == state[2][1] && state[0][1] != emptySpaceSymbol) {
            return true;
        } else if (state[0][2] == state[1][2] && state[1][2] == state[2][2] && state[0][2] != emptySpaceSymbol) {
            return true;
        } else if (state[0][0] == state[1][1] && state[1][1] == state[2][2] && state[0][0] != emptySpaceSymbol) {
            return true;
        } else if (state[0][2] == state[1][1] && state[1][1] == state[2][0] && state[0][2] != emptySpaceSymbol) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean hasMove(ArrayList<int[]> validMoves, int[] move) {
        // Checks if certain move is included in arraylist of valid moves
        for (int i = 0; i < validMoves.size(); i++) {
            if (Arrays.equals(validMoves.get(i), move)) {
                return true;
            }
        }
        return false;
    }

    // Given a state, simply checks whether all spaces are occupied. Does not care or check if a player has won.
    private static boolean checkDraw(char[][] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] == emptySpaceSymbol) {
                    return false;
                }
            }
        }
        return true;
    }

    // Given a game state, return a new game state with move from the AI
    // It follows the algorithm in the PDF to ensure a tie (or win if possible)
    private static char[][] getCPUMove(char[][] gameState) {
        // Hint: you can call makeMove() and not end up returning the result, in order to "test" a move
        // and see what would happen. This is one reason why makeMove() does not modify the state argument

        // Determine all available spaces

        // If there is a winning move available, make that move

        // If not, check if opponent has a winning move, and if so, make a move there

        // If not, move on center space if possible

        // If not, move on corner spaces if possible

        // Otherwise, move in any available spot
        ArrayList<int[]> validMoves = getValidMoves(gameState);
        char cpuSymbol = playerTwoSymbol;
        char plrSymbol = playerOneSymbol;
        int[] center = new int[]{1, 1};
        int[] corner1 = new int[]{0, 0};
        int[] corner2 = new int[]{0, 2};
        int[] corner3 = new int[]{2, 0};
        int[] corner4 = new int[]{2, 2};
        for (int i = 0; i < validMoves.size(); i++) {
            int[] move = validMoves.get(i);
            if (checkWin(makeMove(move,cpuSymbol,gameState))) {
                return (makeMove(move, cpuSymbol, gameState));
            }
        }
        for (int i = 0; i < validMoves.size(); i++) {
            int[] move = validMoves.get(i);
            if (checkWin(makeMove(move, plrSymbol, gameState))) {
                return (makeMove(move, cpuSymbol, gameState));
            }
        }
        if (hasMove(validMoves, center)) {
            return (makeMove(center, cpuSymbol, gameState));
        }
        else if (hasMove(validMoves, corner1)) {
            return (makeMove(corner1, cpuSymbol, gameState));
        }
        else if (hasMove(validMoves, corner2)) {
            return (makeMove(corner2, cpuSymbol, gameState));
        }
        else if (hasMove(validMoves, corner3)) {
            return (makeMove(corner3, cpuSymbol, gameState));
        }
        else if (hasMove(validMoves, corner4)) {
            return (makeMove(corner4, cpuSymbol, gameState));
        }
        else {
         return (makeMove(validMoves.get(0), cpuSymbol, gameState));
        }
    }

    // Given a game state, return an ArrayList of [row, column] positions that are unclaimed on the board
    private static ArrayList<int[]> getValidMoves(char[][] gameState) {
        ArrayList<int[]> validMoves = new ArrayList<int[]>();
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[0].length; j++) {
                if (gameState[i][j] == emptySpaceSymbol) {
                    int[] validMove = new int[2];
                    validMove[0] = i;
                    validMove[1] = j;
                    validMoves.add(validMove);
                }
            }
        }
        return validMoves;
    }

    // Given player names and the game history, display the past game as in the PDF sample code output
    private static void runGameHistory(String[] playerNames, ArrayList<char[][]> gameHistory) {
        // We have the names of the players in the format [playerOneName, playerTwoName]
        // Player one always gets 'X' while player two always gets 'O'
        // However, we do not know yet which player went first, but we'll need to know...
        // Hint for the above: which symbol appears after one turn is taken?

        // Hint: iterate over gameHistory using a loop
        boolean firstPlayer = false;

        for (int i = 0; i < gameHistory.get(1).length; i++) {
            for (int j = 0; j < gameHistory.get(1)[0].length; j++) {
                if (gameHistory.get(1)[i][j] == playerOneSymbol) {
                    firstPlayer = true;
                }
            }
        }

        System.out.println(playerNames[0] + " (X) vs " + playerNames[1] + " (O)");
        System.out.println(displayGameFromState(gameHistory.get(0)));
        for (int i = 1; i < gameHistory.size(); i++) {
            if (firstPlayer) {
                System.out.println(playerNames[0] + ":");
                System.out.println(displayGameFromState(gameHistory.get(i)));
            }
            else {
                System.out.println(playerNames[1] + ":");
                System.out.println(displayGameFromState(gameHistory.get(i)));
            }
            if (i + 1 == gameHistory.size()) {
                if (checkWin(gameHistory.get(i))) {
                    if (firstPlayer) {
                        System.out.println(playerNames[0] + " wins!");
                    }
                    else {
                        System.out.println(playerNames[1] + " wins!");
                    }
                }
                else if (checkDraw(gameHistory.get(i))) {
                    System.out.println("It's a draw!");
                }
            }
            firstPlayer = !firstPlayer;
        }

    }
}