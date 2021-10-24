package com.Bingo;

public class Host {

    public void showPlayerCard() {
        for (Player x : playerSet) {
            System.out.printf("%s's Card\n" , x);
            x.getCard().showCard();
            System.out.println();
        }
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
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

//-----------------------------------------------------------------------------
    
    public Host(Player... players) {
        this.registerPlayer(players);
    }
    public Host() {

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
