public class LogicalOperators{
  public static void main(String[] Args){
    boolean[] array = {true, false};
    
    System.out.println(conjunctionIter(array));
    System.out.println(conjunctionRec(array));
    System.out.println(disjunctionIter(array));
    System.out.println(disjunctionRec(array));
  }
  public static boolean conjunctionIter(boolean array[]){
    boolean x = true;
    //iterate through the array if false found then return false
    for(int i =0; i < array.length; i++){
      if(array[i] == false){
        x = false;
      }
    }
    return x;
    
  }
  public static boolean  conjunctionRec(boolean array[]){
    return  helper2(0, array);
    
  }
  public static boolean disjunctionIter(boolean array[]){
    boolean x = false;
    //iterate through the array if true found then return true
    for(int i =0; i < array.length; i++){
      if(array[i] == true){
        x = true;
      }
    }
    return x;
  }
  public static boolean disjunctionRec(boolean array[]){
    return helper(0, array);
  }
  
  public static boolean helper (int index, boolean[] arr){
    //if no true was found after going through all the array retrun false
    if(index==arr.length)
      return false;
    //if there is only one value in the array array then return it
    else if(arr.length==1)
      return arr[0];
    //if true was found return true
    else if(arr[index]==true)
      return true;
    //if none of the conditions above occured the call the method again after increasing index by 1 
    else
      return helper(index+1,arr);
    
  }
  public static boolean helper2 (int index, boolean[] arr){
    //if no false was found after going through all the array retrun true
    if(index == arr.length)
      return true;
    //if there is only one value in the array array then return it
    else if(arr.length==1)
      return arr[0];
    //if false was found return false
    else if(arr[index] == false)
      return false;
    //if none of the conditions above occured the call the method again after increasing index by 1 
    else
      return helper2(index+1, arr);
    
  }
  
}