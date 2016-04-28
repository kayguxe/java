//hisham hawara
//Mcgill ID: 260624491 
public class Conversion{
    public static void main(String[] args){
      //we store the value of args[0] in the variable binaryN
         String binaryN = args[0];
         char c = ' ';
         //loop through binaryN and store the characters in variable c
         for(int i = 0; i < binaryN.length(); i++){
             c = binaryN.charAt(i);
          }
         convert(binaryN, c);
     }
    //we make method convert to make the proccess of converting the binary numbers into decimal 
    public static void convert(String number, int f){
      //declare variable decimalN and set it to zero to store the value of the decimal number later
         double decimalN = 0;
      // storing the length ofthe array in the variable w
         int w = number.length();
     //we check if the character is even 0 or 1 
         if(f == '0' || f == '1'){
     // if the input is 0 or 1 we loop through the number 
                for(int i =0; i < w ; i++){
     // we check if the character at i is 1
                    if(number.charAt(i) == '1'){
    /* if the character is 1 we call the method twoexponent to convert the binary number into a decimal number 
     * and we store the value in the variable decimalN */
                 decimalN += twoExponent(2, (w - i -1));

                     }
                  }
                //print the value of the number
               System.out.println("The binary number "+ number + " is " + decimalN + " in base 10.");
         }
         //if the charecter wasnt 0 or 1 we print the following message
         else {
            System.out.println("The input is not binary!"); 
         }
         }
    //we make method twoExponent to find the power of a number
         public static int twoExponent(int base, int power) {
              int resultOfPower = 1;
           // if the power was 0 we return resultOfPower because anything to the power of 0 is 1
               if(power == 0){
                  return resultOfPower;
                }
           //if the power wasn't 0 we loop through the array power times and everytime we multiply resultOfPower by the
           //base and we store the value in resultOfPower and we return resultOfPower
               else{
                  for(int i =0; i < power; i++){
                     resultOfPower *= base ;
                  }
                  return resultOfPower;
               }
         }
  }
            
            
  
      
      