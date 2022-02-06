/*
 @author Dilay Yigit
 @version 15.02.2021
 Hangman Game
 */

public class Hangman {
    //instances
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;

    //constructor
    public Hangman(){
        secretWord = new StringBuffer();
        allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        usedLetters = new StringBuffer(26);
        numberOfIncorrectTries = 0;
        maxAllowedIncorrectTries = 6;
        secretWord.append(chooseSecretWord());
        knownSoFar = new StringBuffer(secretWord.length());

        for ( int i = 0; i < secretWord.length(); i++)
            knownSoFar.append("*");
    }

    //get methods
    public StringBuffer getAllLetters(){
        return this.allLetters;
    }

    public StringBuffer getUsedLetters(){
        return this.usedLetters;
    }

    public int getNumOfIncorrectTries(){
        return this.numberOfIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries(){
        return this.maxAllowedIncorrectTries;
    }

    public StringBuffer getKnownSoFar(){
        return this.knownSoFar;
    }

    //other methods
    public String chooseSecretWord() {

        int counter;
        String[] wordList = {"Glass", "Table", "Paper", "Library", "Poster", "Calculus", "Coffee", "Book", "Pen", "Corona"};

        counter = (int) (Math.random() * wordList.length - 1);

        return wordList[counter].toLowerCase();
    }

    public boolean hasLost() {
        if (numberOfIncorrectTries == maxAllowedIncorrectTries)
            return true;
        else
            return false;
    }

    public boolean isGameOver() {
        if (hasLost()) {
            return true;
        } else if (secretWord.toString().equals(knownSoFar.toString().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public int tryThis( char letter ){

        int numberOfFound  = 0;
        for( int i = 0; this.usedLetters.length() > i; i++ ) {
            if( this.usedLetters.charAt(i) == letter ) {
                System.out.print( "The character you have chosen is already used choose another one! " );
                return -1;
            }
        }
        this.usedLetters.append( letter );

        for( int j = 0; this.secretWord.length() > j; j++ ) {
            if( this.secretWord.charAt(j) == letter ){
                this.knownSoFar.setCharAt(j, letter);
                numberOfFound++;
            }
        }

        if( numberOfFound  == 0 )
            this.numberOfIncorrectTries++;
        return numberOfFound ;
    }
}
