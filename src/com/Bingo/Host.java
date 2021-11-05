/*
 *  Author      :       Lee Kai Pui (210 339 487)
 *
 *  Describle   :       This class is for host a game of bingo .
 *                      Also it is an interface to call the mothod
 *                      from player's card class.
 *
 *  Create date :       19-10-2021
 */


package com.Bingo;

public class Host {
//----------------------- [constructor] -------------------------------------

    public Host(Player... players)
    {

        // create an array to store all player that pass in
        this.registerPlayer(players);

        // this is a default value
        // assume the range is from 0 to Player's card row size * column size
        maxValue = maxInput();

        // create an array to track the input inputted
        // maxInput return max possible number of integer can be inputted
        histroicalInput = new int[ maxInput() ];


    }

    // default constructor
    public Host() {
        playerNo = 0;
    };

//------------------------- [ Setter ] ----------------------------------------

    // set the minimum value that can inputted
    public Host setMin(int min)
    {
        this.maxValue = min;
        return this;
    }

    // set the maxmum value that can inputted
    public Host setMax(int max)
    {
        this.maxValue = max;
        return this;
    }


//--------------------------- [ Public method ] -------------------------------

    // builder of class Player instance
    public void newPlayer(String name , int[][] arr )
    {
        this.registerPlayer(new Player(name, arr));
    };

    // show the card hold by player
    public void showPlayersCard() {

        for (Player player : playerSet) {
            // prompt user which user now
            System.out.printf("%s's Card\n" , player);

            player.getCard().showCard();

            // goto nextline to separte player
            System.out.println();

        }
    }

    // check if the input is in the range
    public boolean isInRange(int number ) {
        return (number >= minValue && number <= maxValue);
    }

    // check if the input isn't repeat
    public boolean isRepeatedInput(int number) {

        // if the input appear in histroicalInput array
        // it is not a vaild input
        for(int x : histroicalInput) {
            if (x == number)
                return true;
        }
        //  default
        return false;
    }

    public void update(int number) {

        // To track the input isn't being input
        histroicalInput[inputCount++] = number;

        // foreach player in this game
        // call the updateCard(int) method
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

    // terminate does any one of the player is bingo
    // if yes then prompt user and set the parameter to break out the game loop
    public void Bingo() {
        for (Player player : playerSet )
        {
            if (player.bingo())
            {
                System.out.printf ("%s Bingo" , player);

                // used for end the game
                this.gameStaus = true;
            }

        }
    }


    // terminate does any one of the player get Bingo
    // if yes , then the game will be end
    public final boolean endGame () {
       return this.gameStaus;
    }
//-----------------------------------------------------------------------------
// method to set up the game

    // to track the player in this instance
    private void registerPlayer(Player... players) {
        int newSize = players.length + playerNo;
        Player[] tempArr = new Player[newSize];

        if (playerNo != 0){
            // clone element into temp arr
            for (int i = 0 ; i < playerNo ; ++i) {
                tempArr[i] = playerSet[i];
            }
        }



        // clone the parameter into temp arr
        for (int i = playerNo ; i < newSize ; ++i) {
            tempArr[i] = players[i - playerNo];
        }

        // update the playerSet to new arr
        playerSet = tempArr;
        // update the size
        playerNo = newSize;
    }


//----------------------------[ For Test ]------------------------------------


    public void showPlayer() {
        for (int i = 0 ; i < playerNo ; ++i ) {
            System.out.printf("Player %d : %s\n" , i+1 , playerSet[i]);
        }
    }

    public final int numOfPlayer() {
        return playerNo;
    }
//-----------------------------------------------------------------------------

    private final int maxInput() {
        // pretend all the player array is square matrix
        int max = 0;

        // cursor
        int current;

        for (Player x : playerSet ) {

            current = x.getCard().SIZE;

            if (current > max ) {
                max = current;
            }
        }

        return max * max ;
    }

//-----------------------------------------------------------------------------

    // number of player
    private int playerNo=0;
    // array of the player in *this game
    private Player[] playerSet;

    // store the histroical input
    private int[] histroicalInput;

    // used for input into histroicalInput
    private int inputCount;

    // the range of number on the card
    private int minValue = 1;
    private int maxValue;

    // track any player win the game
    private boolean gameStaus = false;
}
