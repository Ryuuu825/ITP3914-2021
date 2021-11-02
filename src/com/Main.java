package com;

import com.Bingo.*;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // set up array need by Player
        final int cardOne[][] = {
            {24,2,8,1,25},
            {12,16,7,17,15},
            {5,6,20,19,13},
            {14,23,22,4,3},
            {10,18,11,21,9}
        };

        final int cardTwo[][] = {
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

        
        int input;
        



        // main loop 
        while (true) {

            gameOne.showPlayersCard();

            // prompt user
            System.out.printf("Game Host call (0 to exit): ");
            input = sc.nextInt();


            // check the input 
            if (input == 0) { break; };

            if (gameOne.isVaildNumber(input))
            {
                gameOne.update(input);
            }
            else  
            {
                // receive next vaild input
                System.out.printf("Game Host call (0 to exit): The number %d is repeated, please call again!\n" , input);
                continue;
            }


            // check any bingo

        }

        
        


    } 
}
