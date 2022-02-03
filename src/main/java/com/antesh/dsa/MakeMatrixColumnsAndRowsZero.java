package com.antesh.dsa;

/* Antesh Sharma created on 2/3/2022
    TC = O(M x N)
    SC = O(M + N)
    Algorithm:
    1. firstly matrix length should not be zero
    2. create two Hashset<Integer> zero_rows & zero_columns of Integer hashset type to store row/column number
       in which the cell is having value zero.
        3. iterate the row by column matrix and check if matrix[i][j] == 0, if zero then store the row number and
        column number in the respective zero_row & zero_column hashset
        4. Now, we have to make all the column cell value as zero of each row number where zero found
        5. Then, we have to make all the row cell value as zero for each column number where zero found

        6. print matrix, that's all

        */

import java.util.HashSet;
import java.util.Set;

public class MakeMatrixColumnsAndRowsZero {
    public static void main(String[] args) {
        int[][] input = {
                {21, 32, 34, 0},
                {32, 43, 11, 6},
                {33, 0, 23, 35}
        };

        printMatrix(input);
        makeZeroes(input);
        printMatrix(input);

        int[][] input1 = {
                {21, 32, 34, 0},
                {32, 43, 11, 6},
                {33, 0, 23, 35},
                {0, 0, 45, 28},
        };

        printMatrix(input1);
        makeZeroes(input1);
        printMatrix(input1);
    }

    public static void makeZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_columns = new HashSet<>();

        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    zero_rows.add(i);
                    zero_columns.add(j);
                }
            }
        }

        for (int r : zero_rows) {
            for (int i = 0; i < column; i++) {
                matrix[r][i] = 0;
            }
        }

        for (int c : zero_columns) {
            for (int i = 0; i < row; i++) {
                matrix[i][c] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
