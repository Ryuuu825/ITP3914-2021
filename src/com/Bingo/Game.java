package com.Bingo;

public class Game {

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
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

//-----------------------------------------------------------------------------
    
    public Game(Player... players) {
        this.registerPlayer(players);
    }
    public Game() {

    }

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

    
    private int playerNo=0;
    private Player[] playerSet;
    private int histroicalInput;
}
