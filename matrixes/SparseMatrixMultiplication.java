package LeetCode.matrixes;

import java.util.ArrayList;

//O(mkn) complexity
//Let mm and kk represent the number of rows and columns in mat1mat1, respectively. Likewise, let kk and nn represent the number of rows and columns in mat2mat2, respectively.
//https://leetcode.com/problems/sparse-matrix-multiplication/
public class SparseMatrixMultiplication {

    //naive iteration
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < mat2.length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public int[][] multiplyIterative(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;

        // Product matrix will have 'n x m' size.
        int[][] ans = new int[n][m];

        for (int rowIndex = 0; rowIndex < n; ++rowIndex) {
            for (int elementIndex = 0; elementIndex < k; ++elementIndex) {
                // If current element of mat1 is non-zero then iterate over all columns of mat2.
                if (mat1[rowIndex][elementIndex] != 0)  { //optimization
                    for (int colIndex = 0; colIndex < m; ++colIndex) {
                        ans[rowIndex][colIndex] += mat1[rowIndex][elementIndex] * mat2[elementIndex][colIndex];
                    }
                }
            }
        }

        return ans;
    }

    //2 варіант - зробити листи в яких будуть тільки не нульові елементи і тоді множити
//    public ArrayList<ArrayList<Pair<Integer, Integer>>> compressMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        ArrayList<ArrayList<Pair<Integer, Integer>>> compressedMatrix = new ArrayList<>();
//
//        for (int row = 0; row < rows; ++row) {
//            ArrayList<Pair<Integer, Integer>> currRow = new ArrayList<>();
//            for (int col = 0; col < cols; ++col) {
//                if (matrix[row][col] != 0) {
//                    currRow.add(new Pair(matrix[row][col], col));
//                }
//            }
//            compressedMatrix.add(currRow);
//        }
//        return compressedMatrix;
//    }
//
//    public int[][] multiply(int[][] mat1, int[][] mat2) {
//        int m = mat1.length;
//        int k = mat1[0].length;
//        int n = mat2[0].length;
//
//        // Store the non-zero values of each matrix.
//        ArrayList<ArrayList<Pair<Integer, Integer>>> A = compressMatrix(mat1);
//        ArrayList<ArrayList<Pair<Integer, Integer>>> B = compressMatrix(mat2);
//
//        int[][] ans = new int[m][n];
//
//        for (int mat1Row = 0; mat1Row < m; ++mat1Row) {
//            // Iterate on all current 'row' non-zero elements of mat1.
//            for (Pair mat1Element : A.get(mat1Row)) {
//                int element1 = (int)mat1Element.getKey();
//                int mat1Col = (int)mat1Element.getValue();
//
//                // Multiply and add all non-zero elements of mat2
//                // where the row is equal to col of current element of mat1.
//                for (Pair mat2Element : B.get(mat1Col)) {
//                    int element2 = (int)mat2Element.getKey();
//                    int mat2Col = (int)mat2Element.getValue();
//                    ans[mat1Row][mat2Col] += element1 * element2;
//                }
//            }
//        }
//
//        return ans;
//    }


    //3 варіант Yale format
    class SparseMatrix {
        public int cols = 0, rows = 0;
        public ArrayList<Integer> values = new ArrayList<>();
        public ArrayList<Integer> colIndex = new ArrayList<>();
        public ArrayList<Integer> rowIndex = new ArrayList<>();

        // Compressed Sparse Row
        public SparseMatrix(int[][] matrix) {
            rows = matrix.length;
            cols = matrix[0].length;
            rowIndex.add(0);

            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    if (matrix[row][col] != 0) {
                        values.add(matrix[row][col]);
                        colIndex.add(col);
                    }
                }
                rowIndex.add(values.size());
            }
        }

        // Compressed Sparse Column
        public SparseMatrix(int[][] matrix, boolean colWise) {
            rows = matrix.length;
            cols = matrix[0].length;
            colIndex.add(0);

            for (int col = 0; col < cols; ++col) {
                for (int row = 0; row < rows; ++row) {
                    if (matrix[row][col] != 0) {
                        values.add(matrix[row][col]);
                        rowIndex.add(row);
                    }
                }
                colIndex.add(values.size());
            }
        }
    };


    public int[][] multiplyYale(int[][] mat1, int[][] mat2) {
        SparseMatrix A = new SparseMatrix(mat1);
        SparseMatrix B = new SparseMatrix(mat2, true);

        int[][] ans = new int[mat1.length][mat2[0].length];

        for (int row = 0; row < ans.length; ++row) {
            for (int col = 0; col < ans[0].length; ++col) {

                // Row element range indices
                int matrixOneRowStart = A.rowIndex.get(row);
                int matrixOneRowEnd = A.rowIndex.get(row + 1);

                // Column element range indices
                int matrixTwoColStart = B.colIndex.get(col);
                int matrixTwoColEnd = B.colIndex.get(col + 1);

                // Iterate over both row and column.
                while (matrixOneRowStart < matrixOneRowEnd && matrixTwoColStart < matrixTwoColEnd) {
                    if (A.colIndex.get(matrixOneRowStart) < B.rowIndex.get(matrixTwoColStart)) {
                        matrixOneRowStart++;
                    } else if (A.colIndex.get(matrixOneRowStart) > B.rowIndex.get(matrixTwoColStart)) {
                        matrixTwoColStart++;
                    } else {
                        // Row index and col index are same so we can multiply these elements.
                        ans[row][col] += A.values.get(matrixOneRowStart) * B.values.get(matrixTwoColStart);
                        matrixOneRowStart++;
                        matrixTwoColStart++;
                    }
                }
            }
        }

        return ans;
    }
}
