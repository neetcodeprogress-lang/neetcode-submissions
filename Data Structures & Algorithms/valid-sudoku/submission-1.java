class Solution {
    public boolean isValidSudoku(char[][] board) {
        //when is a sudoku board valid: 
            //for each 3x3 box, no duplicates in the entire 3x3 box

        /*
        Does:
        the entire col(9 total singular boxes), there should be no duplicates
        the entire row(9 total singluar boxes), there should be no duplicates

        YES; the entire row and col needs to be unique

        We are not trying to solve the sudoku board; instead, we are trying
        to see if it is valid in its current state.
            - basically if it follows the rules

        Initial Idea:
        - Iterate through each number
            - Check if entire row is valid (all 9 squares)
                - if true continue; if false return false
            - Check if entire column is valid (all 9 squares)
                - if true continue; if false return false
            - Finally check if 3x3 box is valid
                - if true continue to next number, skipping the periods;
                    if false return false

        Draft 2:
        - Iterate through each number in the row
            - for each number:
            - Check if RowSet has the number, if not then add and proceed to next
        - Iterate through each number in the col
            - for each number:
            - Check if ColSet has the number, if not then add and proceed to next
        -iterate through each 3x3 section
            - Check if BoxSet has the number, if not then add and proceed to next

        */

        Set<Character> mySet = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            mySet.clear();
            for(int n = 0; n < board[i].length; n++) {
                if (mySet.contains(board[i][n])) {
                    return false;
                } else {
                    if(Character.isDigit(board[i][n])) {
                        mySet.add(board[i][n]);
                    }
                }
            }
        }

        //didn't activate false; empty temporary set and 
        //move on to columns

        mySet.clear();

        for(int i = 0; i < board[i].length - 1; i++) {
            mySet.clear();
            for (int n = 0; n < board.length; n++) {
                if (mySet.contains(board[n][i])) {
                    return false;
                } else {
                    if (Character.isDigit(board[n][i])) {
                    mySet.add(board[n][i]);
                    }
                }
            }
        }

        //no duplicates found for col and row
        //move on to checking the boxset
        mySet.clear();

        //i,n
        //Top left Box - i,n < 3
        //Top Middle Box - i < 3, 2 > n < 7
        //Top Right Box - i < 3, 5 > n < 9

        /*
        00 01 02 | 03 04 05 | 06 07 08 
        10 11 12 | 13 14 15 | 16 17 18 
        20 21 22 | 23 24 25 | 26 27 28 
        __ __ __   __ __ __   __ __ __ 

        //Middle left box - 2 > i < 6 , n < 3
        //Middle middle box - 2 > i < 6, 2 > n < 7
        //Middle right box - 2 > i < 6, 5 > n < 9

        30 31 32 | 33 34 35 | 36 37 38 
        40 41 42 | 43 44 45 | 46 47 48 
        50 51 52 | 53 54 55 | 56 57 58 
        __ __ __   __ __ __   __ __ __

        //Bottom left box   5 > i < 9 , -1 > n < 3
        //Bottom middle box 5 > i < 9 , 2 > n < 6
        //Bottom right box  5 > i < 9 , 5 > n < 9

        60 61 62 | 63 64 65 | 66 67 68 
        70 71 72 | 73 74 75 | 76 77 78 
        80 81 82 | 83 84 85 | 86 87 88 
        */
        //          0     9 boxes
        for (int box = 0; box < 9; box++) {
            mySet.clear();
            for(int i = 0; i < 3; i++) {
                for (int n = 0; n < 3; n++) {
                    //Had to look this part up:
                    int row = (box/3) * 3 + i;
                    int col = (box % 3) * 3 + n;

                    if (mySet.contains(board[row][col])) {
                        return false;
                    } else if (Character.isDigit(board[row][col])) {
                        mySet.add(board[row][col]);
                    }
                }
            }
        }

            return true; 
        
    }
}
