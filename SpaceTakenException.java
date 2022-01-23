/**
Indicates an attempt to make a move in a space that is already taken.
 */

public class SpaceTakenException extends Exception{
    public String message;
    public SpaceTakenException(String message){
        this.message = message;
    }
}