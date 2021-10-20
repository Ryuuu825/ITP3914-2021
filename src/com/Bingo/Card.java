package com.Bingo;

public class Card {
//-----------------------------------------------------------------------------
    final public String[][] getArr() {
        return cardArray;
    }

    public void updateCard (int target) {
        int[] targetIndex = this.searchIndex(target);

        if ( ! isEmpty(targetIndex) ) {
            int row = targetIndex[0];
            int column = targetIndex[1];

            this.cardArray[row][column] = CROSS;

        }
    }

//-----------------------------------------------------------------------------
    public Card () {} ;

    public Card (String[][] arr) {
        this.cardArray = arr;
    }
    
    
//-----------------------------------------------------------------------------
    private String[][] cardArray;
    final private String CROSS = "XX";

//-----------------------------------------------------------------------------

    // this method search the element in the array 
    // return row , column if element exist
    // else return empty int[]
    private int[] searchIndex (int target)  {
        // used for compare the element in the array
        String tempTarget = Integer.toString(target);
        // cursor
        String current;

        // iterate each element and compare are they same
        for (int row = 0 ; row < this.cardArray.length ; ++row) {

            for (int column = 0 ; column < this.cardArray[row].length ; ++column) {
                
                current = this.cardArray[row][column];

                // used Java default lib to do the comparasion
                // this function return 0 if the exactly the same
                if (current.compareToIgnoreCase(tempTarget) == 0) {
                    return new int[] {row,column};
                }
            }
        }
        // return a empty array if not found
        return new int[] {};
    }

    private boolean isEmpty(int[] targetArr) {
        return ( targetArr.length == 0 );
    }
   

}
