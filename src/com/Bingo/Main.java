package com.Bingo;

public class Main {
    public static void main(String[] args) {
        String[][] player1Card= { 
                {"3"}
        };
        Card test = new Card (player1Card);
        Card copyTest = new Card(test);
        
        Player player1 = new Player("player1" ,  test);
        Player player2 = new Player("Player2" ,  copyTest);
       
        player1.getCard().updateCard(3);


        
        System.out.println(player2.getCard().bingo());

    }
}
