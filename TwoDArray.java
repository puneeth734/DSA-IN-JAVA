import java.util.*;

public class TwoDArray {
    // public static boolean search(int matrix[][], int key){
    //     for(int i=0; i<matrix.length; i++){
    //         for(int j=0; j<matrix[0].length; j++){
    //             if(matrix[i][j] == key){
    //                 System.out.println("Found at cell : ("+i+ ","+ j+")");
    //                 return true;
    //             }
    //         }
    //     }
    //     System.out.println("Key not found");
    //     return false;
    // }

    public static boolean searchLarge(int matrix[][]){
        int maxEle = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(maxEle < matrix[i][j]){
                    maxEle = matrix[i][j];
                    System.out.println("The large element found in ("+i+","+j+")");
                    System.out.println("the large element is"+ maxEle);
                    return true;
                }
            }
        }
        System.out.println("Element not found");
        return false;
    }


    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            //top
            for(int j= startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j] +" ");
            }

            //right
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol]+" ");
            }

            //bottom
            for(int j= endCol-1; j>=startCol; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] +" ");
            }

            //left
            for(int i=endRow-1; i>=startRow; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static int diagnolSum(int matrix[][]){  //O(n^2)
        int sum = 0;

        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(i == j){
        //             sum += matrix[i][j];
        //         }else if(i+j == matrix.length-1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        //2nd approach
        for(int i=0; i<matrix.length; i++){
            //primary daigonal
            sum += matrix[i][i];
            // seconday diagonal
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }


    public static boolean staircaseSeach(int matrix[][], int key){
        int row= 0, col=matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] ==  key){
                System.out.println("Found key at: ("+row+","+ col +")");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key not found!!!");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n= matrix.length;
        int m= matrix[0].length;

       Scanner sc = new Scanner(System.in);
       for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

       for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] +" ");
            }
        System.out.println();
        }

    //     search(matrix, 8);
         searchLarge(matrix);

    // int matrix[][] = {
    //     {1,2,3,4},
    //     {5,6,7,8},
    //     {9,10,11,12},
    //     {13,14,15,16}
    // };
    // printSpiral(matrix);

    // System.out.println(diagnolSum(matrix));

    // int matrix[][] = {
    //     {10,20,30,40},
    //     {15,25,35,45},
    //     {27,29,37,48},
    //     {32,33,39,50}
    // };
    // int key = 50;
    // staircaseSeach(matrix, key);

    }

    
}
