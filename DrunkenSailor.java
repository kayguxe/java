//hisham hawara
//Mcgill ID: 260624491 
import java.util.*;
public class DrunkenSailor{
  public static void main(String[] args){
    // declare variable x and set it equal to user input(args[o])/declare variable y and set it equal to 2
    int x = Integer.parseInt(args[0]);
    int y = 2;
    //declare multi d array steps of type int and set its size to x and y
     int [][] steps = new int[x][y];
     int count = 0;
     //call the method getr and assign it to the array re
     int [][] re = getr(steps, count);
     //call the method printmatrix of re to print the matrix
     printMatrix(re);
     //call method max to print the furthest point and the distance
     max(re);
  }
  
  
     public static int[][] getr(int [][] ls, int count){
            Random random = new Random();
      // setting the length of the array to nrows   
            int nrows = ls.length;
      //setting the length of the array to the number of columns 
            int ncols = ls[0].length;
            //declaring array result and setting its size to the number of rows and number of columns
            int result [][] = new int [nrows][ncols];
           // we loop through the rows
            for (int i = 0; i < nrows; i++) { 
              //loop through the first column
                 for (int j = 0; j < ncols-1; j++) {
              // generate random number and assign it to r
                        int rand = random.nextInt(50 + 1) + 0;
             // we set the the first element in the array to zero to start with zero           
                        result [0][0] = 0;
             // we set the values in first coloumn of result to the value of the first column in ls + the random count
                        result [i][0] = ls[i][0] + count;
                        //if the random number generated is less than 25 increase the count by 1
                        if(rand < 25){
                           count +=1;
                         }
                        //if the random number generated is bigger than 25and less than 50 decrease the count by 1 
                        else if(rand < 50 ){
                               count -=1;
                         }
                 } 
           }
           for (int i = 0; i < nrows; i++) { 
               for (int j = 0; j < ncols-1; j++) {
                        int rand = random.nextInt(50 + 1) + 0;
                        result[0][1] = 0;
                 // we set the values in secon coloumn of result to the value of the first column in ls + the random count
                        result[i][1] = ls[i][1] + count;
                        if(rand < 25){
                            count +=1;
                         }
                        else if( rand < 50 ){
                            count -=1;
                        }
                } 
           }
       
                    return result;
          }
     
     
     public static void max(int [][]array){
         int max1 = 0;
         int max2 = 0;
         double maxDistance = 0.0;
         // loop through the array finding the distance between every two point find the largest and printing it as the
         //maximum distance also looping through the array to find the largest two points and printing them
         for(int i = 0; i < array.length; i++){
            for(int j =0; j < array[i].length; j++){
                int col1 = array[i][0];
                int col2 = array[i][1];
                 double distance = Math.sqrt(Math.pow(col1,2) + Math.pow(col2,2));
                 if(distance > maxDistance){
                      maxDistance = distance;
                        max1 = col1;
                        max2 = col2; 
                   }
            }
          }
               System.out.println("final Distance = " + maxDistance);
               System.out.println("furthest point = (" + max1 +", " + max2 + ")");
     }
     
     //method to print the array, we loop thro it and print the values
     public static void printMatrix(int [][] numbers){
            for(int i = 0; i < numbers.length; i++){
                 System.out.print("(");
               for(int j = 0; j< numbers[i].length; j++){
                   System.out.print( numbers[i][j] + " ");

                }
            System.out.println(")");
            }

     }
}




  
    