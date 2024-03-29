/**  
    Represents a tic tac toe board. 
    Players are 'x' and 'o'. 
    Empty spaces are represented by the space character.
    @author Janet,Ankit,Noah.
*/
   

public class TicTacToeBoard{
    private final int SIZE = 3;
    private char[][] board = new char[SIZE][SIZE];

    
    /*
     * Initizlizes board spaces to empty space
     */
    public TicTacToeBoard(){
        // Initializing array with blank spaces.
        for(int i=0; i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                board[i][j]=' ';
            }
        }
    }

    /*
     * @returns int SIZE: the size of the tic tac toe board
     */
    public int getSize(){
        return SIZE;
    }

    /*
     * outputs the current board
     */
    public void printBoard(){
        String separator = "";
        for(int i=0; i<SIZE;i++){
            separator += "+---";
        }
        separator+="+";
        System.out.println(separator);
        for(int i=0; i<SIZE; i++){
            String line = "| ";
            for(int j=0; j<SIZE; j++){
                line+= board[i][j];
                line+= " | ";
            }
            System.out.println(line);
            System.out.println(separator);
        }
        
    }

    /*
     * checks if a point is on the board and raises an exception if not
     * @param int row: the row
     * @params int col: the column
     * @throws tttIndexException
     */
    private void checkBounds(int row, int column) throws tttIndexException{
      if(!((0 <= row && row<SIZE) && (0 <= column && column<SIZE))){
          throw new tttIndexException("row/column pair not in board");
      }
    }
    
    /*
     * checks that given row/column pair is available
     * @param int row: the row to check
     * @param int column: the col to check
     * @throws tttIndexException: if out of bounds
     */
    public boolean isOpen(int row, int column) throws tttIndexException{
      checkBounds(row, column);
      return ' ' == board[row][column];
    }

    /*
     * Marks a space
     * @param int row: integer between 0 and size-1
     * @param int column: integer between 0 and size-1
     * @param char mark: a character 'x' or 'o'
     * @throws SpaceTakenException: if the space is taken
     * @throws tttIndexException: if out of bounds
     */
    public void markSpace(int row, int column, char mark) throws tttIndexException, SpaceTakenException{
      checkBounds(row, column);
      if(!isOpen(row, column)){
        throw new SpaceTakenException("Space has been taken");
      }
      board[row][column] = mark;
    }

    /*
     * check if game is tied
     * @returns True if no spaces are unmarked
     */
    public boolean isTied() throws tttIndexException{
      for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
          if(isOpen(i,j))
          {
            return false;
          }
        }
      }
      return true;
    }

    /*
     * checks if a given player has won
     * @param char mark: the mark of the player to be checked
     * @returns boolean: true if the player with the given mark has won
     */
    public boolean isWonBy(char mark){

      //check rows
      for(int i = 0; i < SIZE; i++)
      {
        char[] row = board[i];
        if(match(row, mark))
        {
          return true;
        }
      }

      //check columns
      for(int i = 0; i < SIZE; i++)
      {
        char[] column = new char[SIZE];
        for(int j = 0; j < SIZE; j++){
          column[j] = board[j][i];
        }
        if(match(column, mark))
        {
          return true;
        }
      }

      //check diaganols
      char[] down = new char[SIZE];
      char[] up = new char[SIZE];
      for(int i = 0; i < SIZE; i++)
      {
        down[i] = board[i][i];
        up[i] = board[SIZE-1-i][i];
      }
      if(match(down, mark) || match(up, mark))
        return true;
      return false;
    }

    /*
     * returns if the given list contains only the given mark
     * @params char[] spaces: an array of characters
     * @parms char mark: a character to match
     */
    public boolean match(char[] spaces, char mark)
    {
      for(int i = 0; i < SIZE; i++)
      {
        char s = spaces[i];
        if(s != mark)
        {
          return false;
        }
      }
      return true;
    }

}
