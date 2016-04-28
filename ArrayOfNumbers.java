//hisham hawara
//Mcgill ID: 260624491 

public class ArrayOfNumbers{
  public static void main(String args[]){
 //declare two arrays a and b
    int[] a = {2, 3, 5, 1, 2, 3};
    int[] b = {2, 3, 5, 1, 2, 3};
  //call the methods findMissingNum and findMostFrequent
    findMissingNum(6, a);
    findMostFrequent(6, b);

     
  
  }
  
  public static void findMissingNum(int n, int[] array){ 
    //declare a boolean variable check to check future conditions later
    boolean check = false;
    int i, j;
    //we loop through the numbers from 1 to n and from the first element to the last element in the array and then
    // if the element from 1 to n equals  the number from the array we break out of the array
    for( j = 1; j <= n; j++){
  for( i =0; i < array.length; i++){
    if(array[i] == j ){
        break;
    }
    }
    // if we looped through the array and there is still numbers between 1 and n that didnt meet the previous condition
  // we print them and they are the missing numbers and we set check to true
  if(i == array.length)
    {
      check = true;
      System.out.print(j + " ");
    }
   }
   //if check is not true (no missing number) print the following statement 
    if(!check){
     System.out.println("No missing number.");
    }
    System.out.println();
  }
 public static void findMostFrequent(int n, int[] array){
   //checking if the array is empty and if it is empty we print the following message
           if (array.length == 0) {
               System.out.println("array is empty");
            }
           int first = 0;
           int count = 1;
           int max = 0;
           int [] counts = new int[n];
           int [] finalA = new int[n];
            boolean condition = false;
    //we loop through the array from o to n, we set y to the first element and then we check if their is more than 1 ofthe value and we increment the count for
   //everyone
           for(int i =0; i < n; i++){
                 count = 0;
                 int y = array[i];
                 for(int j = 0; j < n; j++){
                     if(y == array[j]){
                        count++;
                      }
                  }
         //we set the counts inside an array called counts
                   counts[i] = count;
                   count = 1;
         //we set max to the fist element in the counts array
                   max = counts[0];
         //we check if their is a value bigger than max and if their is one we make it max
          for(int d =0; d < n; d++){
                if(counts[i] > max){
                    max = counts[i];
                 }
          }
          }
   //we check if the counts at each one from 0 to n if they equal to max we loop through another
         for(int s =0; s < n; s++){
           condition = false;
           if(counts[s] == max) {
   //checking for the same value 
               for(int k=0; k < s; k++) {
   //we are checking if their is a number before it thats equal to it 
               if( array[s] == array[k] ) {
                 condition = true;
               }
               }
   // if its the first number of its kind we put in in the array finalA and then we break
             if (!condition) {
               for(int k = 0; k < n; k++) {
                 if (finalA[k] == 0) {
                   finalA[k] = array[s];
                   break;
                 }
               }
               
             }
         }
           
           
   }
   //if finalA is not zero we print 
   int k = 0;
   while (finalA[k] != 0) {
     System.out.print(finalA[k] );
     System.out.print(" ");
     
     k++;
   }
   System.out.println();
   
}
}



       
  
    

        

  
 
  

  



  