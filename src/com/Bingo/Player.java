package com.Bingo;


public class Player {
//-----------------------------------------------------------------------------

    public Card getCard() {
        return this.playerCard;
    }

    @Override public String toString() {
        return playerName;
    }

    public void update (int target)  {
        this.playerCard.update(target);
    }
//-----------------------------------------------------------------------------
// constructor

    public Player (String name) {
        this.playerName = name;
        this.playerCard = new Card();
    }

    public Player (String name , Card card) {
        this.playerName = name;
        this.playerCard = card;
    }

    private Player(){};
//-----------------------------------------------------------------------------

    private Card playerCard;
    private String playerName;

//-----------------------------------------------------------------------------

}