/*
 *  Author      :       Lee Kai Pui (210 339 487) 
 * 
 *  Describle   :       A class interact with Card instance  
 * 
 *  Last modify :       2-11-2021 (18:00) HKT
 * 
 * 
 */

package com.Bingo;


public class Player {

//---------------------------- [ Constructor ] --------------------------------

// automactiy create a Card instance for player    
public Player (String name , int[][] cardArr) {
    this.playerName = name;
    this.playerCard = new Card(cardArr) ;
}

// Different player can point to the same Card instance address
public Player (String name , Card card) {
    this.playerName = name;
    this.playerCard = card;
}

// hide the constructor
private Player(){}

//-----------------------------------------------------------------------------

    @Override 
    public String toString() {
        return playerName;
    }


    // a public method to terminate if the player bingo
    public final boolean bingo() {
        return this.playerCard.haveBingo();
    }


    // get the card hold by player
    // used to update the card , show the card
    // therefore the return type can't be const 
    protected Card getCard() {
        return this.playerCard;
    }


//----------------------------- [ Member ] ------------------------------------

    private Card playerCard;
    private String playerName;

//-----------------------------------------------------------------------------
}