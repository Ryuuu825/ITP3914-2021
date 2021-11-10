/*
 *  Author      :       Lee Kai Pui (210 339 487)
 *
 *  Describle   :       A class interact with Card instance
 *
 *  Create date :       19-10-2021
 *
 */


package com.Bingo;

public class Player {

//---------------------------- [ Constructor ] --------------------------------

    // automactiy create a Card instance for player
    public Player (final String name , final int[][] cardArr) 
    {
        this.playerName = name;
        this.playerCard = new Card(cardArr) ;
    }


    public Player (final String name , final Card card) 
    {
        this.playerName = name;
        // deep copy of Card instances
        this.playerCard = new Card(card);
    }

    // hide the constructor
    private Player(){}

//------------------------ [ Public method ] -------------------------------------
    // print the name of player
    @Override
    public String toString() 
    {
        return playerName;
    }

    
    // a public method to terminate if the player bingo
    public final boolean bingo() 
    {
        if (this.playerCard.haveBingo() ) 
            return true;

        // default value
        return false;
    }


    // get the card hold by player
    // used to update the card , show the card
    // therefore the return type can't be const
    protected final Card getCard() 
    {
        return this.playerCard;
    }


//----------------------------- [ Member ] ------------------------------------

    // var that store the Card instance hold by this instance
    private Card playerCard;

    // the name of player
    private String playerName;
}
