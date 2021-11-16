/*
 *  Author      :       Lee Kai Pui (210 339 487) (IT114105/1B)
 *
 *  Describle   :       This class is for host a game of bingo .
 *                      Also it is an interface to call the mothod
 *                      from player's card class.
 *
 *  Create date :       19-10-2021
 *  Last Modify :       16-11-2021
 * 
 */


package com.Bingo;

public class Host {
//----------------------- [constructor] -------------------------------------

    public Host(Player... players)
    {

        // create an array to store all player that pass in
        this.registerPlayer(players);

        // this is a default value
        // assume the range is from 0 to {Player's card row size * column size}
        // and increase by 1
        // for example : 5 X 5 card the default max value is 25
        maxValue = maxInput();

        // create an array to track the input inputted
        // maxInput return max possible amount of integer can be inputted
        histroicalInput = new int[ maxInput() ];
    }


    // default constructor
    public Host() 
    {
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
    public void newPlayer(final String name , final int[][] arr )
    {
        this.registerPlayer(new Player(name, arr));
    };


    // show the card hold by player
    public void showPlayersCard() 
    {
        for (Player player : playerSet) 
        {
            // prompt user which player now
            System.out.printf("%s's Card\n" , player);

            player.getCard().showCard();

            // goto nextline to separte player
            System.out.println();

        }
    }


    // check if the input is in the range
    public boolean isInRange(int number ) 
    {
        return (number >= minValue && number <= maxValue);
    }


    // check if the input isn't repeat
    public boolean isRepeatedInput(int number) 
    {

        // if the input appear in histroicalInput array
        // it is not a vaild input
        for(int x : histroicalInput) 
        {
            if (x == number)
                return true;
        }
        //  default
        return false;
    }


    public void update(final int number) 
    {
        // To track the input isn't being input
        histroicalInput[inputCount++] = number;

        // foreach player in this game
        // call the updateCard(int) method
        for ( Player x : playerSet ) 
        {
            x.getCard().updateCard(number);
        }
    }

    // terminate does any one of the player is bingo
    // if yes then prompt user and set the parameter to break out the game loop
    public void Bingo() 
    {
        for (Player player : playerSet )
        {
            if (player.getCard().haveBingo() )
            {
                System.out.printf ("%s Bingo!\n" , player);

                // used for end the game
                this.gameStatus = true;
            }

        }
    }


    // terminate does any one of the player get Bingo
    // if yes , then the game will be end
    public final boolean isEndGame () 
    {
       return this.gameStatus;
    }


    public void showPlayer() 
    {
        for (int i = 0 ; i < playerNo ; ++i ) {
            System.out.printf("Player %d : %s\n" , i+1 , playerSet[i]);
        }
    }


    public final int numOfPlayer() 
    {
        return playerNo;
    }

//---------------------- [ Private Method ] -----------------------------------

    // to track the player in this instance
    // copy value into new dymanic array
    private void registerPlayer(Player... players) {
        int newPlayerNo = players.length + playerNo;
        // new playerSet array
        Player[] newPlayerSet = new Player[newPlayerNo];

        // copy from old array if player exist
        if (playerNo != 0){
            // clone element in playerSet into temp arr
            for (int i = 0 ; i < playerNo ; ++i) {
                newPlayerSet[i] = playerSet[i];
            }
        }

        // clone the parameter into temp arr
        for (int i = playerNo ; i < newPlayerNo ; ++i) {
            newPlayerSet[i] = players[i - playerNo];
        }

        // update the playerSet to new arr
        // this array is dymanic 
        this.playerSet = newPlayerSet;
        // update the size
        this.playerNo = newPlayerNo;
    }


    // pretend all the player array is square matrix
    private final int maxInput() {
        int max = 0;

        // cursor
        int current;

        for (Player x : playerSet ) {
            current = x.getCard().SIZE;

            if (current > max ) {
                max = current;
            }
        }
        // row size * column sizeß
        return max * max ;
    }

//-----------------------------------------------------------------------------

    // number of player
    private int playerNo=0;
    
    // array of the player in *this game
    // a dymanic array
    private Player[] playerSet;

    // store the histroical input
    private int[] histroicalInput;

    // used for input into histroicalInput
    private int inputCount;

    // the range of number on the card
    private int minValue = 1;
    private int maxValue;

    // track any player win the game
    private boolean gameStatus = false;
}
