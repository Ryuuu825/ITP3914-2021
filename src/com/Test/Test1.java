/*	
 *	Author 		:	Lee Kai Pui (210339487) (IT114105/1B)
 *	
 *	File 		: 	Test.java
 *	
 *	Describe	: Wrote a small test to test some function use in Main:wq
 *			      and see if they work as I expected.
 */

package com.Test;
import com.Bingo.*;

public class Test1 {
    public static void main( String argv[] ) 
    {
        // set up the game
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

        // setup the game
        Host testGame = new Host(
            new Player("player 1" , cardOne)
        );

       
        // test constructor 
        // assert(testGame.numOfPlayer() == 1 );
        System.out.println(testGame.numOfPlayer() == 1 );


        testGame.newPlayer("player 2 ", cardTwo);

        // assert(testGame.numOfPlayer() == 2 );
        System.out.println(testGame.numOfPlayer() == 2);

        // default input 
        int input[] = {28,-2 ,16,10,10,22,6,20,18,2,23};

        for (int i = 0 ; i < input.length ; ++i) 
        {
            // check this two isn't expected 
            if (i == 1) 
            {
                System.out.println( ! testGame.isInRange(input[i]) );
            }
            else if ( i == 4 ) 
            {
                System.out.println( testGame.isRepeatedInput(input[i]));
            }

            testGame.update(input[i]);
            testGame.Bingo();

        }

        // assert(testGame.endGame());
        System.out.println(testGame.endGame());
    }
}
