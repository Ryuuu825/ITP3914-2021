/*	
 *	Author 		:	Lee Kai Pui (210339487) (IT114105/1B)
 *	
 *	File 		: 	Test2.java
 *	
 *	Describe	:   Wrote a small test to test registerPlayer()
 */

package com.Test;
import com.Bingo.*;

public class Test2 {
    public static void main( String argv[] ) 
    {
        // set up the game
        final int[][] cardOne = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        

        // setup the game
        Host testGame = new Host(
            new Player("player 1" , cardOne),
            new Player("player 1" , cardOne),
            new Player("player 1" , cardOne),
            new Player("player 1" , cardOne),
            new Player("player 1" , cardOne)
            
        );
       
        // test the constructor 
        // assert(testGame.numOfPlayer() == 1 );
        System.out.println(testGame.numOfPlayer() == 5 );


        testGame.newPlayer("player 2 ", cardOne);
        testGame.newPlayer("player 2 ", cardOne);
        testGame.newPlayer("player 2 ", cardOne);
        testGame.newPlayer("player 2 ", cardOne);
        testGame.newPlayer("player 2 ", cardOne);

        // test the newPlayer() 
        // assert(testGame.numOfPlayer() == 2 );
        System.out.println(testGame.numOfPlayer() == 10);

        // default input 
        int input[] = {-10,1,1,1,1,1};

        for (int i = 0 ; i < input.length ; ++i) 
        {
            // check this two isn't expected 
            if (i == 0) 
            {
                System.out.println( ! testGame.isInRange(input[i]) );
            }
            else if ( i >= 2 ) 
            {
                System.out.println( testGame.isRepeatedInput(input[i]));
            }

            testGame.update(input[i]);
            testGame.Bingo();

        }

        // assert(testGame.endGame());
        System.out.println(! testGame.endGame());
    }
}
