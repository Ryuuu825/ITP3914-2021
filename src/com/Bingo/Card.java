/*
 *  Author      :   Lee Kai Pui 
 * 
 *  File Name   :   Card.java
 * 
 *  Desrcibe    :   This class is used for track information of the player's card.
 *                      ->  Do they have Bingo?
 *                      ->  show the card 
 *                      ->  update the card
 *                  
 *                  The Player class can shard the same instance of <Card> class.
 * 
 *  
 * 
 *  Create Date :   19-10-2021
 *
 */

package com.Bingo;

public class Card {


//------------------------ [ Constructor ] ------------------------------------

    // any instances of Card is not allow to point to same array
    // the array should be square matrix

    public Card (final int[][] arr) 
    {
        // checking if the array past in isn't a square matrix
        checkSquareMatrix(arr);

        // deep copy
        this.cardArray = copyArr(arr);

        this.SIZE = this.cardArray.length;
    }

    // deep copy
    public Card (final Card other)
    {
        this.cardArray = copyArr(other.cardArray);

        this.SIZE = this.cardArray.length;

    }

//------------------------ [ Main Algoritrms ] --------------------------------------
// Here is something you may want to take a look


    /*
     * check does any one of the row have CROSS arranged on this instance in same row
     * which mean that all element in that row are CORSS
     * 
     * Implement:
     *      iterate each row and check condition above.
     *      goto next iteration early if one element in that row isn't CROSS
     */
    private final boolean checkRow() {
        
        // cursor
        int current;

        NEXTROW : 
            for (int row = 0 ; row < this.SIZE ; ++row) {

                for (int column = 0 ; column < this.SIZE ; ++column) {

                    current = this.cardArray[row][column];

                    // goto next row if one element isn't "XX"
                    if (! isCross(current)) {
                        continue NEXTROW;
                    }
                }
                // all element in that row is "XX" when the porgram able to reach here
                return true;
            }
        // default
        return false;
    }

    /*
     * check does any one of the row have "XX" arranged on their card in same column
     * which mean that all element in that column are "XX"
     * 
     *  Implement:
     *      simialr with acheckRow
     *      iterate each column and check condition above 
     *      Goto next iteratation earily if one element in that column isn't CROSS 
     */
    private final boolean checkColumn() {
        NEXTCOL:
            for (int column = 0  ; column < this.SIZE ; ++column ) {
                for (int row = 0 ; row < this.SIZE ; ++row ) {
                    if ( this.cardArray[row][column] != CROSS ) 
                        continue NEXTCOL;
                }
                // that mean all element is that column are CROSS
                // if the program able to reach here
                return true;
            }
        // default
        return false;
    }


//--------------------------- [ Main Method ] ------------------------------

    // terminate if this instance is bingo or not
    protected boolean haveBingo() 
    {
        return checkRow() || checkColumn();
    }


    // get the const references of the 2D array
    // not allow to change the value 
    protected final int[][] getArr() 
    {
        return this.cardArray;
    }


    // update the number in 2D array which the number is inputted by host
    protected void updateCard (final int target) 
    {

        // serach where to update the value
        // return empty array if not found
        int[] targetIndex = this.searchIndex(target);

        if ( isEmpty(targetIndex) ) { return; };
       

        int row = targetIndex[0];
        int column = targetIndex[1];
        this.cardArray[row][column] = CROSS;
    }


    // print all element in the array
    // print "XX" if the element is occupied (which is -1)
    protected void showCard() 
    {
        for (final int[] row : this.cardArray)
        {
            for (final int current : row) 
            { 
                if ( current == CROSS ) 
                    System.out.printf("XX\t");
                else
                    System.out.printf("%d\t" ,  current);
            }
            // go to nextline of each row
            System.out.println();
        }
    }


//------------------------------ [ Member variable ] --------------------------------------

    // the card
    private int[][] cardArray;

    // size of the card 
    //      -> e.g. 5 X 5
    // since it must be a square matrix
    // only need to store one value
    protected final int SIZE;

    // pre-define word
    // -1 is used for exit the game that never pass into updateCard() 
    // so -1 is most suitable 
    final private int CROSS = -1;



    
   
//----------------------- Private Method -----------------------------------

    /* 
     * this method search the element in the array 
     * return the index if element exist
     * else return a empty int[]
     * please remind that only return first match value
     */
    private final int[] searchIndex (final int target)  {
 
         // cursor
         int current;
        
         // using O(n^2)

         // iterate each element and compare are they same
         for (int row = 0 ; row < this.cardArray.length ; ++row) {
 
             for (int column = 0 ; column < this.cardArray[row].length ; ++column) {
                 
                 current = this.cardArray[row][column];
 
                 if ( current == target ) {
                     return new int[] {row,column};
                 }
             }
         }
         // return a empty array if not found
         return new int[] {};
    }



    // Copy the value of the parameter (2D array) to a new 2D array
    // and return the new array
    private int[][] copyArr(final int[][] arr) {

        // copy the value in the array to a new array

        final int rowLen = arr.length;
        int[][] temp = new int[rowLen][]; // 2D arr

        for (int row = 0 ; row < rowLen ; ++row) {

            final int columnLen = arr[row].length;
            temp[row] = new int[columnLen]; // 1D arr

            for (int column = 0 ; column < columnLen ; ++column) {
                // copy by value not references
                temp[row][column] = Integer.valueOf( arr[row] [column] );
            }
        }

        return temp;
    }

    // ensure the array have same row size and column size
    private boolean checkSquareMatrix ( final int arr[][] ) 
    {
        final int rowSize = arr.length;

        for (int i = 0 ; i < rowSize ; ++i ) {
            if (arr[i].length != rowSize )
                // use print error to replace throw exception
                System.err.println("Not a square matrix");
        }
        return true;
    }

    private boolean isEmpty(final int[] targetArr) {
        return ( targetArr.length == 0 );
    }

    private boolean isCross (final int target) {
        return  ( target == CROSS ) ;
    }
}
