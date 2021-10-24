package com.Bingo;

public class Host {

    public void showPlayerCard() {
        for (Player x : playerSet) {
            System.out.printf("%s's Card\n" , x);
            x.getCard().showCard();
            System.out.println();
        }
    }

    public boolean isVaildNumber(int number) {
        if (number < 0) 
            return false;
        
        for(int x : histroicalInput) {
            if (x == number) 
                return false;
        }

        return true;
        
        
    }
//-----------------------------------------------------------------------------

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

    public void update(int number) {
        histroicalInput[inputCount++] = number;
        
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

//-----------------------------------------------------------------------------
    
    public Host(Player... players) {
        this.registerPlayer(players);

        // this must need to change
        histroicalInput = new int[25];

    }
    public Host() {
        // this must need to change
        histroicalInput = new int[25];
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

    
//-----------------------------------------------------------------------------

    // number of player
    private int playerNo=0;
    // array of the player in *this game
    private Player[] playerSet;

    // store the histroical input
    private int[] histroicalInput;
    // used for input into histroicalInput
    private int inputCount;
}
