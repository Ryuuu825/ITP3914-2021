package com.Bingo;

public class Host {
//-----------------------------------------------------------------------------
// after set up the Game

    public void showPlayersCard() {
        for (Player x : playerSet) {

            System.out.printf("%s's Card\n" , x);
            x.getCard().showCard();
            System.out.println();

        }
    }

    public boolean isVaildNumber(int number) {
        // check the input is or not in the range
        if (number < minValue || number > maxValue) 
            return false;
        
        // if the input appear in histroicalInput array
        // it is not a vaild input
        for(int x : histroicalInput) {
            if (x == number) 
                return false;
        }

        return true;  
    }

    public void update(int number) {

        // track the input isn't being input
        histroicalInput[inputCount++] = number;
        
        // foreach player in this game
        // call the update method
        // to replace number with "XX"
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

//-----------------------------------------------------------------------------
// method to set up the game
    public void registerPlayer(Player... players) {
        
        int tempSize = players.length + playerNo;
        Player[] temp = new Player[tempSize];

        // clone element into temp arr
        for (int i = 0 ; i < playerNo ; ++i) {
            temp[i] = playerSet[i];
        }

        for (int i = playerNo ; i < tempSize ; ++i) {
            temp[i] = players[i - playerNo];
        }
        
        playerSet = temp;
        playerNo = tempSize;
    }

//-----------------------------------------------------------------------------
    
    public Host(Player... players) {
        this.registerPlayer(players);

        // create a array to track the input
        // maxInput return max possible number of integer can be inputted
        histroicalInput = new int[this.maxInput()];
        System.out.println(histroicalInput.length);

        maxValue = maxInput();

    }

    public Host() {
        // create a array to track the input
        // maxInput return maximum possible number of integer can be inputted
        histroicalInput = new int[this.maxInput()];
        maxValue = maxInput();

    };

//-----------------------------------------------------------------------------


    public void showPlayer() {
        for (int i = 0 ; i < playerNo ; ++i ) {
            System.out.printf("Player %d : %s\n" , i+1 , playerSet[i]);
        }
    }

    public final int numOfPlayer() {
        return playerNo;
    }
//-----------------------------------------------------------------------------

    public final int maxInput() {
        // pretend all the player array is square matrix
        int max = 0;

        for (Player x : playerSet ) {

            if (x.getCard().SIZE > max ) {
                max = x.getCard().SIZE;
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
    // static array
    private int[] histroicalInput;

    // used for input into histroicalInput
    private int inputCount;

    // the range of number on the card
    private final int minValue = 0;
    private final int maxValue;
}
