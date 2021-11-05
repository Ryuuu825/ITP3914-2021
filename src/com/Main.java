/*
 *  Author      :       Lee Kai Pui (210339487)
 *
 *  File        :       Main.java
 *
 *  Desrcibe    :       A simple Bingo console game.
 *                      This file is the main game loop.
 *
 *  Create Date :       19-10-2021
-2
16
10
10
22
6
20
18
2
23


 */

package com;

import com.Bingo.*;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

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
                new Player("Player 1" , cardOne ) ,
                new Player("Player 2" , cardTwo )
            );


        // for receive input
        int input;

//-------------------------- [ Main Game Loop ] ---------------------------------------------------
         // show the all player's card at the begining
        gameOne.showPlayersCard();

        while ( ! gameOne.endGame() ) {

            // prompt user
            System.out.printf("Game Host call (0 to exit): \n");
            input = sc.nextInt();


            // exit the program if input is 0
            if (input == 0) { break; }

            // check is the input in the range
            if ( ! gameOne.isInRange(input))
            {
                System.out.println("The number must be between 1 to 25, please call again! \n");
                continue;
            }
            // check if the input is inputted before
            else if (gameOne.isRepeatedInput(input))
            {
                System.out.printf("The number %d is repeated, please call again!\n" , input);
                continue;
            }
            // the input are valid
            else
            {

                // update all player's card
                gameOne.update(input);

                // show the card that hold by the player at the end of the loop
                gameOne.showPlayersCard();

                // check does anyone bingo
                // prompt user and end the game if someone bingo
                gameOne.Bingo();

            }


        }

        // close the scanenr before the program end
        sc.close();

    }
}
