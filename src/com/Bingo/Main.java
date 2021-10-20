package com.Bingo;

public class Main {
    public static void main(String[] args) {
        String[][] player1Card= { 
                {"3"}
        };
       
        Player player1 = new Player("player1" ,  new Card (player1Card));
        Player player2 = new Player("Player2" ,  new Card (player1Card));
       
        player1.getCard().updateCard(3);
        player2.getCard().updateCard(1);

        String[][] temp = player1.getCard().getArr();

        for (String[] x : temp)  {
            for (String y : x) {
                System.out.print(y + "\t");
            }
            System.out.println('\n');
        }

    }
}
