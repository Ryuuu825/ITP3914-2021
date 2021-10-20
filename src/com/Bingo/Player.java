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