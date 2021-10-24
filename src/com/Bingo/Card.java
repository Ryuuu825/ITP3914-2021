/*
 *  This card class can be either shared same instance by few ppl
 *  or copy constructor is provide to copy value but different instance
 * 
 *
 */

package com.Bingo;

public class Card {
//-----------------------------------------------------------------------------

    // this method convert the 2D int array to 2D String array
    public static String[][] toStringArr(int arr[][]) {

        String o_tempArr[][] = new String[arr.length][];

        for (int i = 0 ; i < arr.length ; ++i) {
            int size = arr[i].length;
            o_tempArr[i] = new String[size];

            // convert the int value to String and copy into o_tempArr
            for (int j = 0 ; j < size ; ++j) {
                o_tempArr[i][j] = Integer.toString(arr[i][j]);
            }
        }
        
        return o_tempArr;
    }

//-----------------------------------------------------------------------------
    final protected String[][] getArr() {
        return cardArray;
    }

    protected void  updateCard (final int target) {
        int[] targetIndex = this.searchIndex(target);

        if ( ! isEmpty(targetIndex) ) {
            int row = targetIndex[0];
            int column = targetIndex[1];

            this.cardArray[row][column] = CROSS;

        }
    }
    
    protected boolean haveBingo() {
        return checkRow();
    }

    protected void showCard() {
        for (String[] x : this.cardArray) {
            for (String y :x) {
                System.out.printf("%s\t" , y);
            }
            System.out.println();
        }
    }

//-----------------------------------------------------------------------------


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
                // check current isn't the {target}
                if (current.compareToIgnoreCase(tempTarget) == 0) {
                    return new int[] {row,column};
                }
            }
        }
        // return a empty array if not found
        return new int[] {};
    }

    private boolean isCross (final String target) {
        return  ( target.compareToIgnoreCase(CROSS) == 0 ) ;
    }

//-----------------------------------------------------------------------------

    /*
     * check does any one of the row have "XX" arranged on their card in same row
     * which mean that all element in that row are "XX"
     * 
     * Implement:
     *      iterate each row and check condition above.
     *      goto next iteration if the element isn't "XX"
     */
    private boolean checkRow() {
        
        String current;
        NEXTROW : for (int row = 0 ; row < this.cardArray.length ; ++row) {

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
    private void checkColumn() {
        String current;

        int count = 0;
        int[] columnToCheck = {};
        
        for (int column = 0 ; column < this.cardArray[0].length ; ++column) {
            if ( isCross(this.cardArray[0][column]) )  {
                columnToCheck[count++] = column;
            }
        }
    }

    private boolean isEmpty(final int[] targetArr) {
        return ( targetArr.length == 0 );
    }
   
//-----------------------------------------------------------------------------
    private String[][] copyArr(final String[][] arr) {

        // copy the Array by value

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
