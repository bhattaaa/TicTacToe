/**
tttIndexException raised when user tries to include the point not on the board.
 */


public class tttIndexException extends Exception{
    public String message;
    public tttIndexException(String message){
        this.message = message;
    }
}