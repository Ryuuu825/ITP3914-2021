package com.Bingo;

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
        Game game1 = new Game();
        game1.registerPlayer(testplayer);
        game1.registerPlayer(new Player("Test player" , test ));

        game1.update(1);
        game1.update(3);
        game1.update(2);

        for (String[] x : test.getArr()) {
            for (String y : x) {
                 System.out.print(y+"\t");
            }
            System.out.println();
        }
        
        System.out.println(testplayer.bingo());

        

    }
}
