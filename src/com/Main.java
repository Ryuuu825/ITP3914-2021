package com;

import com.Bingo.*;

public class Main {
    public static void main(String[] args) {
        String[][] player1Card= { 
                {"3","2" , "1"},
                {"5","6" , "7"},
                {"30","10" , "9"}

        };
        Card test = new Card (player1Card);
        Card copyTest = new Card(test);
               
        Player testplayer = new Player("Test player" , test );
        Host game1 = new Host();
        game1.registerPlayer(testplayer);
        game1.registerPlayer(new Player("Test player" , test ));

        game1.update(1);
        game1.update(3);
        game1.update(2);

        
        
        System.out.println(testplayer.bingo());

        

    }
}
