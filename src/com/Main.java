package com;

import com.Bingo.*;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // set up the game
        int cardOne[][] = {
            {24,2,8,1,25},
            {12,16,7,17,15},
            {5,6,20,19,13},
            {14,23,22,4,3},
            {10,18,11,21,9}
        };

        int cardTwo[][] = {
            {24,21,17,15,6},
            {10,3,8,18,20},
            {14,7,16,12,5},
            {25,23,13,19,11},
            {22,4,9,1,2}
        };
        
        com.Bingo.Player playerOne = new com.Bingo.Player("Player 1" , cardOne );
        com.Bingo.Player playerTwo = new com.Bingo.Player("Player 2" , cardTwo );

        com.Bingo.Host gameOne = new com.Bingo.Host();
        gameOne.registerPlayer(playerOne , playerTwo);

        int input;
        while (true) {
            input = sc.nextInt();

            if (input == 0) {
                break;
            }
            gameOne.update(input);
            gameOne.showPlayerCard();


        }

        
        


    } 
}
