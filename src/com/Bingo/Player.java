package com.Bingo;


public class Player {
//-----------------------------------------------------------------------------

    @Override public String toString() {
        return playerName;
    }

    public boolean bingo() {
        return this.playerCard.haveBingo();
    }

//-----------------------------------------------------------------------------
// constructor

    
    public Player (String name , int cardArr[][]) {
        this.playerName = name;
        this.playerCard = new Card( Card.toStringArr(cardArr) ) ;
    }

    // Different player can point to the same Card instance
    // which mean they shared same card
    public Player (String name , Card card) {
        this.playerName = name;
        this.playerCard = card;
    }

    private Player(){};
//-----------------------------------------------------------------------------

    private Card playerCard;
    private String playerName;

//-----------------------------------------------------------------------------

    protected Card getCard() {
        return this.playerCard;
    }
//-----------------------------------------------------------------------------
}