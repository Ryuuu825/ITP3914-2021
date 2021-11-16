/*
 *  Author      :       Lee Kai Pui (210339487) (IT114105/1B)
 *
 *  File        :       Main.java
 *
 *  Desrcibe    :       A simple Bingo console game.
 *                      This file is the main game loop.
 *
 *  Create Date :       19-10-2021
 *  Last Modify :       16-11-2021
 *  
 */

package com;

import com.Bingo.*;
import java.util.Scanner;

public class Main {

// --------------------------[ Visible in this class ] ------------------------

    // for receive input
    public static Scanner sc = new Scanner(System.in);
    
// --------------------------[ Main ] -----------------------------------------

    public static void main(String[] args) 
    {
        int input;

        // set up array need by player one
        final int[][] cardOne = {
            {24,2,8,1,25},
            {12,16,7,17,15},
            {5,6,20,19,13},
            {14,23,22,4,3},
            {10,18,11,21,9}
        };

        // set up array need by player two
        final int[][] cardTwo = {
            {24,21,17,15,6},
            {10,3,8,18,20},
            {14,7,16,12,5},
            {25,23,13,19,11},
            {22,4,9,1,2}
        };

        // set up a game which have two player
        Host gameOne = new Host(
                new Player("Player1" , cardOne ) ,
                new Player("Player2" , cardTwo )
            );

//-------------------------- [ Game Loop ] ---------------------------------------------------

        // show the all player's card at the begining
        gameOne.showPlayersCard();

        while ( ! gameOne.isEndGame() ) 
        {
                        
            // keep receive input util have a valid input
            input = validInput(gameOne);

            // exit the program if input is 0
            if (input == 0) 
                break; 
            
            // update all player's card
            gameOne.update(input);

            // show the card that hold by the player at the end of the loop
            gameOne.showPlayersCard();

            // check does anyone bingo
            // prompt user and end the game if someone bingo
            gameOne.Bingo();
        }

        // close the scanenr before the program end
        sc.close();

        // exit the program

    }


    // continue loop util receive a valid input
    public static int validInput(final Host game) 
    {
        int temp; 

        while (true) 
        {
                // prompt user
                System.out.printf("Game Host call (0 to exit): ");
                // receive an input
                temp = sc.nextInt();
                
                // exit signal inputted by user
                // count as valid input
                if ( temp == 0 ) { return 0 ; }

                // check if the input is in the range
                if ( ! game.isInRange(temp) )
                {
                    System.out.println("The number must be between 1 to 25, please call again!\n");
                    continue;
                }
                // check if the input is inputted before
                else if ( game.isRepeatedInput(temp) )
                {
                    System.out.printf("The number %d is repeated, please call again!\n" , temp);
                    continue;
                }
                else 
                {
                    return temp;
                }
            
        }
    }

    
}
