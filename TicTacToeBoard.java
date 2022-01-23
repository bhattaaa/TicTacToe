/**  
    Represents a tic tac toe board. 
    Players are 'x' and 'o'. 
    Empty spaces are represented by the space character.
    @author Janet,Ankit,Noah.
    */
   

public class TicTacToeBoard{
    private final int SIZE = 3;
    private char[][] board = new char[SIZE][SIZE];

    
    public TicTacToeBoard(){
        // Initializing array with blank spaces.
        for(int i=0; i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                board[i][j]=' ';
            }
        }
    }
    public int getSize(){
        return SIZE;
    }
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
    private void checkBounds(int row, int column) throws tttIndexException{
        if(!((0 <= row && row<SIZE) && (0 <= column && column<SIZE))){
            throw new tttIndexException("row/column pair not in board");
        }
    }
}
