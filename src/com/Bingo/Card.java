package com.Bingo;

public class Card {
//-----------------------------------------------------------------------------
    final public String[][] getArr() {
        return cardArray;
    }

    public void updateCard (final int target) {
        int[] targetIndex = this.searchIndex(target);

        if ( ! isEmpty(targetIndex) ) {
            int row = targetIndex[0];
            int column = targetIndex[1];

            this.cardArray[row][column] = CROSS;

        }
    }
    
    public boolean bingo() {
        return checkRow();
    }

//-----------------------------------------------------------------------------

    public Card () {} ;

    public Card (final String[][] arr) {
        // prevent other instance point to same array
        this.cardArray = copyArr(arr);
    }
    
    public Card (final Card other) {
        // prevent other instance point to same array
        this.cardArray = copyArr(other.cardArray);
    }
    
//-----------------------------------------------------------------------------
    private String[][] cardArray;
    final private String CROSS = "XX";

//-----------------------------------------------------------------------------

    /* 
     * this method search the element in the array 
     * return row , column if element exist
     * else return empty int[]
     * please remind that only return first match value
     */
    private int[] searchIndex (final int target)  {
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


    // check is it able to bingo
    private boolean checkRow() {
        String current;
        NEXTROW : for (int row = 0 ; row < this.cardArray.length ; ++row) {

            for (int column = 0 ; column < this.cardArray[row].length ; ++column) {
                current = this.cardArray[row][column];

                // goto next row if one element isn't "XX"
                if (current.compareToIgnoreCase(CROSS) != 0) {
                    continue NEXTROW;
                }
            }
            // all element in that row is "XX" when porgram reach here
            return true;
        }
        // default
        return false;
    }

    private boolean isEmpty(final int[] targetArr) {
        return ( targetArr.length == 0 );
    }
   
//-----------------------------------------------------------------------------
    private String[][] copyArr(final String[][] arr) {

        final int rowLen = arr.length;
        String[][] temp = new String[rowLen][]; // 2D arr

        for (int row = 0 ; row < rowLen ; ++row) {

            final int columnLen = arr[row].length;
            temp[row] = new String[columnLen]; // 1D arr

            // copy all element in arr into temp
            for (int column = 0 ; column < columnLen ; ++column) {
                temp[row][column] = arr[row][column];
            }
        }

        return temp;
    }
}
