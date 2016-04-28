public class  ParseDigits{
  public static void main(String[] args){
   // we identify number as a variable of type integer and we assign it to the value of args[0] after converting it from a string to an integer
  int number = Integer.parseInt(args[0]);
  // the variable digit4 represent the 5th digit of the number 
  int digit4 = number % 10;
  // the variable digit3 represent the 4th digit of the number
  int digit3 = number%100/10 ;
    // the variable digit2 represent the 3th digit of the number
  int digit2 = number%1000/100;
    // the variable digit1 represent the 2th digit of the number
  int digit1 = number%10000/1000;
    // the variable digit0 represent the 1th digit of the number
  int digit0 = number%100000/10000;
  //we define the product variable and we assign it to the product of the digits
  int product = digit0 * digit1* digit2* digit3* digit4;
  //we define the sum variable and we assign it to the sum of the digits 
  int sum = digit0 + digit1 + digit2 + digit3 + digit4; 
  //printing the values of sum and product
    System.out.println("the sum of the digits is " + sum);
    System.out.println("the product of the digits is " + product);
    //comparing values using if statement  
      if (product > sum){
    System.out.println("The product is larger than the sum");
  }
      else if (product < sum){
        System.out.println("The sum is larger than the product");
      }
  else{
    System.out.println("The sum is equal to the product");
  }

  }
}