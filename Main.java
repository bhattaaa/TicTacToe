import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
  private static Random randgen = new Random();
  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args)throws tttIndexException{
    play();
  }

  /**
  Play the game. Returns nothing,called for side effects.
   */
  public static void play() throws tttIndexException{
      boolean isHumanTurn = randgen.nextBoolean();
      TicTacToeBoard board = new TicTacToeBoard();
      System.out.println("Let's play tic tac toe!!");
      System.out.println("You are x and computer is o");
      if(isHumanTurn){
        System.out.println("You go first");
      }
      else{
        System.out.println("The computer goes first");
      }
      scanner.nextLine();
      System.out.println();
      boolean gameover = false;
      while(!gameover){
        if(isHumanTurn){
          humanTurn(board);
        }
        else{
          computerTurn(board);
        }
        board.printBoard();
        System.out.println();
        if(board.isWonBy(isHumanTurn ? 'x':'o')){
          String player = isHumanTurn ? "You" : "The computer";
          System.out.println(player + " won!");
          gameover = true;
        }
        else if (board.isTied()){
          System.out.println("It's a lie");
          gameover = true;
        }
        isHumanTurn = ! isHumanTurn;
      }
      System.out.println("===GAME OVER===");
  }

  /**
    Gets a row and column from the human player, and marks an "X" accordingly.
    Parameter: board, a TicTacToeBoard
    Returns: Nothing, called for side effects.
   */
  private static void humanTurn(TicTacToeBoard board){
    System.out.println("It's your turn");
    boolean turnover = false;
    while(!turnover){
      System.out.println("Row "+Integer.toString(board.getSize()));
      int row = scanner.nextInt();
      System.out.println("Column "+Integer.toString(board.getSize()));
      int column = scanner.nextInt();
      try{
        board.markSpace(row-1,column-1,'x');
        turnover=true;
      }
      catch(tttIndexException e){
        System.out.println("The space is out of bounds.Please try again.");
      }
      catch(SpaceTakenException e){
        System.out.println("The space is taken. Please try again.");
      }
    }
  }

  /*
   * gets numeric input from user, asking until valid input
   * @param String rowOrColumn
   * @param int size
   * @returns the integer the user typed
   */
  public static int getInput(String rowOrColumn, int size){
    boolean validInput = false;
    int number = -1;
    while(!validInput){
      System.out.println("What " + rowOrColumn + "? (1-"+Integer.toString(size)+") ");
      try
      {

        number = scanner.nextInt();
        if(number < 1 || number > size)
        {
          System.out.println("Please enter a number in the range 1-" + Integer.toString(size)+".");
          continue;
        }
        validInput = true;
      }
      catch(InputMismatchException e){
        System.out.println("Please enter an integer.");
      }
    }
    return number;
  }

  /**
   * Marks an 'o' in a randomly chosen space.
   */
  private static void computerTurn(TicTacToeBoard board){
    boolean turnOver = false;
    while(!turnOver){
      int row = randgen.nextInt(board.getSize());
      int column = randgen.nextInt(board.getSize());
      try
      {
        board.markSpace(row, column, 'o');
        System.out.println("The computer marks " + Integer.toString(row+1) + ',' + Integer.toString(column+1));
        turnOver=true;
      }
      catch(tttIndexException e){
        continue;
      }
      catch(SpaceTakenException e){
        continue;
      }
    }
  }

    
}


