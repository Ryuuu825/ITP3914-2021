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
 *  Last modify :   2-11-2021 (17:32)
 *
 */

package com.Bingo;

public class Card {


//------------------------ constructor ------------------------------------

    // any instances of Card is not allow to point to same array
    // the array should be square matrix

    public Card (final int[][] arr) {
        this.cardArray = Card.toStringArr(arr);

        if (this.cardArray.length != this.cardArray[0].length ) {
            System.err.printf("Not a Square matrix");
        }

        this.SIZE = this.cardArray.length;

    }

    public Card (final Card other) {
        
        this.cardArray = copyArr(other.cardArray);

        if (this.cardArray.length != this.cardArray[0].length ) {
            System.err.printf("Not a Square matrix");
        }

        this.SIZE = this.cardArray.length;

    }

//--------------------------- Main Method ------------------------------

// terminate if this instance is bingo
protected boolean haveBingo() {
    return checkRow();
}


// get the const references of the 2D array
// not allow to change the value 
protected final String[][] getArr() {
    return this.cardArray;
}


// update the number input by host in the 2D array 
protected void updateCard (final int target) {

    // serach where to update the value
    // return empty array if not found
    int[] targetIndex = this.searchIndex(target);

    if ( ! isEmpty(targetIndex) ) {
        int row = targetIndex[0];
        int column = targetIndex[1];

        this.cardArray[row][column] = CROSS;
    }
}


// print all element in the array
protected void showCard() {
    for (final String[] x : this.cardArray)
    {
        for (final String y :x) 
        {
            System.out.printf("%s\t" , y);
        }
        System.out.println();
    }
}



//------------------------------- Static Function -------------------------------------

    // this method convert the 2D int array to a new 2D String array
    public static String[][] toStringArr(final int arr[][]) {

        String o_tempArr[][] = new String[arr.length][];

        for (int i = 0 ; i < arr.length ; ++i) {
            int size = arr[i].length;
            o_tempArr[i] = new String[size];

            // convert the int value to String and copy into o_tempArr
            for (int j = 0 ; j < size ; ++j) {
                // copy the value only 
                o_tempArr[i][j] = Integer.toString(arr[i][j]);
            }
        }
        
        return o_tempArr;
    }


//------------------------------ Member variable --------------------------------------

    // the card
    private String[][] cardArray;

    // size of the card 
    //      -> e.g. 5 X 5
    protected final int SIZE;

    // pre-define word
    final private String CROSS = "XX";


//------------------------ Main Algoritrms --------------------------------------


    /*
     * check does any one of the row have "XX" arranged on their card in same row
     * which mean that all element in that row are "XX"
     * 
     * Implement:
     *      iterate each row and check condition above.
     *      goto next iteration if the element isn't "XX"
     */
    private final boolean checkRow() {
        
        // cursor
        String current;

        NEXTROW : 
            for (int row = 0 ; row < this.cardArray.length ; ++row) {

                for (int column = 0 ; column < this.cardArray[row].length ; ++column) {

                    current = this.cardArray[row][column];

                    // goto next row if one element isn't "XX"
                    if (! isCross(current)) {
                        continue NEXTROW;
                    }
                }
                // all element in that row is "XX" when porgram reach here
                return true;
            }
        // default
        return false;
    }

    /*
     * check does any one of the row have "XX" arranged on their card in same column
     * which mean that all element in that column are "XX"
     */
    private final boolean checkColumn() {
        return false;
    }

    
   
//----------------------- Private Method -----------------------------------

    /* 
     * this method search the element in the array 
     * return the index if element exist
     * else return empty int[]
     * please remind that only return first match value
     */
    private final int[] searchIndex (final int target)  {
        // this.cardArray is a String[][]
        // therefore need to convert the target into String first 
         final String tempTarget = Integer.toString(target);
 
         // cursor
         String current;
 
         // iterate each element and compare are they same
         for (int row = 0 ; row < this.cardArray.length ; ++row) {
 
             for (int column = 0 ; column < this.cardArray[row].length ; ++column) {
                 
                 current = this.cardArray[row][column];
 
                 // used Java default lib to do the comparasion
                 // check current isn't the {target}
                 if (current.compareToIgnoreCase(tempTarget) == 0) {
                     return new int[] {row,column};
                 }
             }
         }
         // return a empty array if not found
         return new int[] {};
    }



    // Copy the value of the parameter (2D array) to a new 2D array
    // and return the new array
    private String[][] copyArr(final String[][] arr) {

        // copy the Array by value
        final int rowLen = arr.length;
        String[][] temp = new String[rowLen][]; // 2D arr

        for (int row = 0 ; row < rowLen ; ++row) {

            final int columnLen = arr[row].length;
            temp[row] = new String[columnLen]; // 1D arr

            for (int column = 0 ; column < columnLen ; ++column) {
                // copy by value not references
                temp[row][column] = new String(arr[row][column]);
            }
        }

        return temp;
    }

    private boolean isEmpty(final int[] targetArr) {
        return ( targetArr.length == 0 );
    }

    private boolean isCross (final String target) {
        return  ( target.compareToIgnoreCase(CROSS) == 0 ) ;
    }
}
