public class Marking{
  public static void main(String[] args){
    printMaximum(2,2);
    double result;
    result = maximum(3,3);
    System.out.println(result);
    int finalGrades;
    finalGrades = finalGrade(28,4,1,30);
    System.out.println(finalGrades);
  
  }
  // we define a  method called printMaximum that takes as input two double arguments a and b
  public static void printMaximum(double a, double b){
    //we compare a to b and if a is larger than b we print the following statement
    if(a > b){
      System.out.println(a +" is larger than " + b);
    }
    //we compare b to a and if b is larger than a we print the following statement
     else if(b > a){
      System.out.println(b + "is larger than " + a);
    }
     //if a is equal to b we print the following statement 

  
  }
    // we define a  method of type double called maximum that takes as input two double arguments x and y
  public static double maximum(double x, double y){
   // if the the value of x is larger than y we return x
    if(x > y){
      return x;
    }
  // if the the value of y is larger than x we return y
    else if(y > x){
      return y;
    }
    // if both values are equal we return anyone of them and this case we return x
    else {
      return x;
    }
  }
    // we define a  method of type int called finalGrade that takes as input four int arguments 
  public static int finalGrade(int assignments, int quizzes, int midterm, int Final){
    double x = assignments + quizzes + midterm + Final;
    double y = assignments + quizzes + (Final * 60)/40;
   // we use the maximum method to compare the values of x and y and we return the larger
    int result = (int)maximum(x,y);
    return result;
    }



}