package processor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double[][] matrixOne;
    static double[][] matrixTwo;
    static double[][] resultMatrix;

    static int rawOne;
    static int columnOne;
    static int rawTwo;
    static int columnTwo;
    static double multiply;

    public static double[][] readMatrix() {
        // Read dimensions of first matrix
        System.out.print("Enter size of matrix: ");
        int raw = scanner.nextInt();
        int column = scanner.nextInt();

        // Create matrix
        double[][] matrix = new double[raw][column];

        // Read elements of first matrix
        System.out.print("Enter matrix: ");
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Double.parseDouble(scanner.next().replaceAll(",", "\\."));
            }
        }
        return matrix;
    }

    public static void printResultMatrix(double[][] resultMatrix) {
        DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        System.out.println("The result is: ");
        for (double[] matrix : resultMatrix) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(df.format(matrix[j]) + " ");
            }
            System.out.println();
        }
    }

    public static void multiply() {
        // Read first matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne = matrixOne[0].length;

        // Read second matrix
        matrixTwo = readMatrix();
        rawTwo = matrixTwo.length;
        columnTwo = matrixTwo[0].length;

        // Create result matrix
        resultMatrix = new double[matrixOne.length][matrixTwo[0].length];

        if (matrixOne[0].length == matrixTwo.length) {
            for (int i = 0; i < matrixOne.length; i++) {
                for (int j = 0; j < matrixTwo[0].length; j++) {
                    for (int k = 0; k < matrixOne[0].length; k++) {
                        resultMatrix[i][j] = resultMatrix[i][j] + matrixOne[i][k] * matrixTwo[k][j];
                    }
                }
            }
        } else {
            System.out.println("The operation cannot be performed.");
        }

        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void addMatrices() {
        // Read first matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne = matrixOne[0].length;

        // Read second matrix
        matrixTwo = readMatrix();
        rawTwo = matrixTwo.length;
        columnTwo = matrixTwo[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        // Compute result matrix
        if (rawOne == rawTwo && columnOne == columnTwo) {
            for (int i = 0; i < rawOne; i++) {
                for (int j = 0; j < columnOne; j++) {
                    resultMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
                }
            }
            // Print result matrix
            printResultMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
        System.out.println();
        showStartMenu();
    }

    public static void multiplyByConstant() {
        // Read first matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne = matrixOne[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        // Read multiply number
        System.out.print("Enter constant: ");
        multiply = scanner.nextDouble();

        // Compute result matrix
        for (int i = 0; i < rawOne; i++) {
            for (int j = 0; j < columnOne; j++) {
                resultMatrix[i][j] = matrixOne[i][j] * multiply;
            }
        }
        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void transposeByMainDiagonal() {
        // Read matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne= matrixOne[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                resultMatrix[i][j] = matrixOne[j][i];
            }
        }

        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void transposeBySideDiagonal() {
        // Read matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne= matrixOne[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                resultMatrix[i][j] =
                        matrixOne[matrixOne.length - 1 - j][ matrixOne[0].length - 1 - i];
            }
        }

        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void transposeByVerticalLine() {
        // Read matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne= matrixOne[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                resultMatrix[i][j] = matrixOne[i][ matrixOne[0].length - 1 - j];
            }
        }

        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void transposeByHorizontalLine() {
        // Read matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne= matrixOne[0].length;

        // Create result matrix
        resultMatrix = new double[rawOne][columnOne];

        for (int i = 0; i < matrixOne.length; i++) {
            System.arraycopy(matrixOne[matrixOne.length - 1 - i], 0, resultMatrix[i], 0, matrixOne[0].length);
        }

//        for (int i = 0; i < matrixOne.length; i++) {
//            for (int j = 0; j < matrixOne[0].length; j++) {
//                resultMatrix[i][j] = matrixOne[matrixOne.length - 1 - i][j];
//            }
//        }

        // Print result matrix
        printResultMatrix(resultMatrix);

        showStartMenu();
    }

    public static void showTransposeMenu() {
        System.out.println("\n1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                transposeByMainDiagonal();
                break;
            case 2:
                transposeBySideDiagonal();
                break;
            case 3:
                transposeByVerticalLine();
                break;
            case 4:
                transposeByHorizontalLine();
                break;
        }
    }

    public static void calculateDeterminant() {
        // Read first matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne = matrixOne[0].length;

        if (rawOne == columnOne) {
            System.out.println("The result is:\n" + matrixDeterminant(matrixOne));
        } else {
            System.out.println("The operation cannot be performed.");
        }

        showStartMenu();
    }

    public static double matrixDeterminant (double[][] matrix) {
        double temporary[][];
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, (double) i) * matrixDeterminant (temporary);
        }
        return (result);
    }

    public static void invertMatrix() {
        // Read first matrix
        matrixOne = readMatrix();
        rawOne = matrixOne.length;
        columnOne = matrixOne[0].length;

        resultMatrix = invertMatrix(matrixOne);

        printResultMatrix(resultMatrix);
    }

    public static double[][] invertMatrix (double[][] matrix) {
        double[][] auxiliaryMatrix, invertedMatrix;
        int[] index;

        auxiliaryMatrix = new double[matrix.length][matrix.length];
        invertedMatrix = new double[matrix.length][matrix.length];
        index = new int[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            auxiliaryMatrix[i][i] = 1;
        }

        transformToUpperTriangle (matrix, index);

        for (int i = 0; i < (matrix.length - 1); ++i) {
            for (int j = (i + 1); j < matrix.length; ++j) {
                for (int k = 0; k < matrix.length; ++k) {
                    auxiliaryMatrix[index[j]][k] -= matrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            invertedMatrix[matrix.length - 1][i] = (auxiliaryMatrix[index[matrix.length - 1]][i] / matrix[index[matrix.length - 1]][matrix.length - 1]);

            for (int j = (matrix.length - 2); j >= 0; --j) {
                invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

                for (int k = (j + 1); k < matrix.length; ++k) {
                    invertedMatrix[j][i] -= (matrix[index[j]][k] * invertedMatrix[k][i]);
                }

                invertedMatrix[j][i] /= matrix[index[j]][j];
            }
        }

        return (invertedMatrix);
    }

    public static void transformToUpperTriangle (double[][] matrix, int[] index) {
        double[] c;
        double c0, c1, pi0, pi1, pj;
        int itmp, k;

        c = new double[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < matrix.length; ++i) {
            c1 = 0;

            for (int j = 0; j < matrix.length; ++j) {
                c0 = Math.abs (matrix[i][j]);

                if (c0 > c1) {
                    c1 = c0;
                }
            }

            c[i] = c1;
        }

        k = 0;

        for (int j = 0; j < (matrix.length - 1); ++j) {
            pi1 = 0;

            for (int i = j; i < matrix.length; ++i) {
                pi0 = Math.abs (matrix[index[i]][j]);
                pi0 /= c[index[i]];

                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;

            for (int i = (j + 1); i < matrix.length; ++i) {
                pj = matrix[index[i]][j] / matrix[index[j]][j];
                matrix[index[i]][j] = pj;

                for (int l = (j + 1); l < matrix.length; ++l) {
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
                }
            }
        }
    }

    public static void showStartMenu() {
        System.out.print("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit\n" +
                "Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addMatrices();
                break;
            case 2:
                multiplyByConstant();
                break;
            case 3:
                multiply();
                break;
            case 4:
                showTransposeMenu();
                break;
            case 5:
                calculateDeterminant();
                break;
            case 6:
                invertMatrix();
                break;
            case 0:
                break;
        }
    }

    public static void main(String[] args) {
        showStartMenu();
    }
}