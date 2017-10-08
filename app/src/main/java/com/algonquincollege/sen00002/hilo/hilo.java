package com.algonquincollege.sen00002.hilo;

import java.util.Random;

/**
 * The purpose of this app is to make guesses from numbers 1 to 1000 and you will be given 10 chances if
 * you take less then five chances you are a great player and if you take more than 5 chances then you are
 * a good player and if you lose then you obviously suck!!
 *
 * @author Rajat + Sen (sen00002@algonquinlive.com)
 *         October 07,2017
 */

public class hilo {

    private static final short GUESS_LIMIT = 10;
    private short theNumber, userGuess, userGuessCount;
    private String message;

    // CONSTRUCTORS
    public hilo() {
        setUserGuessCount((short) 0);
        setTheNumber();
        setMessage("");
    }

    // Getter and Setter
    public static short getGuessLimit() {
        return GUESS_LIMIT;
    }

    public short getTheNumber() {
        return theNumber;
    }

    public void setTheNumber() {
        Random rand = new Random();
        int theRandomNumber = rand.nextInt(1001);
        this.theNumber = (short) theRandomNumber;
    }

    public short getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(short userGuess) {
        this.userGuess = userGuess;
    }

    public short getUserGuessCount() {
        return userGuessCount;
    }

    public void setUserGuessCount(short userGuessCount) {
        this.userGuessCount = userGuessCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void userGuessCountIncrement() {
        userGuessCount = (short) (userGuessCount + 1);
    }


    // game play
    public boolean gamePlay(short userGuess) {
        setUserGuess(userGuess);
        userGuessCountIncrement();
        short userGuessCountRemain = (short) (GUESS_LIMIT - userGuessCount);

        if (userGuessCountRemain > 0) {
            if (theNumber == userGuess) {
                if (userGuessCount <= (GUESS_LIMIT / 2)) {
                    setMessage("Superior win!");
                } else {
                    setMessage("Excellent win!");
                }
                return true;
            } else {
                if (userGuess < theNumber) {
                    setMessage("Too Low !");
                    return false;
                }
                if (userGuess > theNumber) {
                    setMessage("Too High !");
                    return false;
                }
            }
        } else {
            setMessage("Please Reset! Play again.");
            return false;
        }
        return false;
    }


    // game reset function
    public void hilo_playagain() {
        setUserGuessCount((short) 0);
        setTheNumber();
        setMessage("");
    }

}
