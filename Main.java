import java.util.Random;
import java.util.Scanner;
public class Main{
  private static Random randgen = new Random();
  private Scanner scanner = new Scanner(System.in);
  public static void main(String[] args)throws tttIndexException, SpaceTakenException{
    

  }

  /**
  Play the game. Returns nothing,called for side effects.
   */
  public void play(){
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
  private void humanTurn(board){
    System.out.println("It's your turn");
    boolean turnover = false;
    while(!turnover){
      System.out.println("Row "+Integer.toString(board.getSize()));
      int row = scanner.nextInt();
      System.out.println("Column "+Integer.toString(board.getSize()));
      int column = scanner.nextInt();
      try{
        board.markSpace(row-1,column-1,'x');
      }
      catch(tttIndexException e){
        System.out.println("The space is out of bounds.Please try again.");
      }
      catch(SpaceTakenException e){
        System.out.println("The space is taken. Please try again.");
      }




    }
  }


}


