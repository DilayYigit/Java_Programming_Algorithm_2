/*
 @author Dilay Yigit
 @version 15.02.2021
 Hangman Game
 */

import java.util.Scanner;
public class HangmanTest {
    public static void main( String[] args ){

        // Variables
        Hangman player = new Hangman();
        Scanner scan = new Scanner(System.in);
        char temp;
        System.out.println( "All letters: " + player.getAllLetters() );
        System.out.println( "max incorrect answer: " + player.getMaxAllowedIncorrectTries() );

        do {
            System.out.println( "Used letters: " + player.getUsedLetters() );
            System.out.println( "Known letters: " + player.getKnownSoFar() );
            System.out.print( "Enter a letter: ");
            temp = scan.next().charAt(0);
            player.tryThis(temp);
        }
        while (!player.isGameOver() && !player.hasLost());

        if ( player.hasLost() ) {
            System.out.println( "You lost" );
        }
        else {
            System.out.println( "You won" );
        }
    }
}