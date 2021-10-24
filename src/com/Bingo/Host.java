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
        if (number < 0 || number > 25) 
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

        // track the input isn't being input
        histroicalInput[inputCount++] = number;
        
        for (Player x : playerSet) {
            x.getCard().updateCard(number);
        }
    }

//-----------------------------------------------------------------------------
    
    public Host(Player... players) {
        this.registerPlayer(players);

        // this must need to change
        histroicalInput = new int[this.maxInput()];

    }

    public Host() {
        // this must need to change
        histroicalInput = new int[this.maxInput()];
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

    private final int maxInput() {
        int maxRow = 0;
        int maxCoulmn = 0;


        for (Player x : playerSet ) {
            if (x.getCard().rowSize > maxRow ) {
                maxRow = x.getCard().rowSize;
            }

            if (x.getCard().columnSize > maxCoulmn ) {
                maxCoulmn = x.getCard().columnSize;
            }

        }

        return maxRow * maxCoulmn;
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
}
