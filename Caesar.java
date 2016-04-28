public class Caesar {
  public static void main(String[] args){
  System.out.println(encode("fffzff"));
    System.out.println(decode("iiicii"));
  }
  
  public static String encode(String plaintext) {
    String ciphertext = "";
    for(int i = 0; i < plaintext.length(); i++){
         char curreChar = plaintext.charAt(i);
         int currInt = (int) curreChar;
         currInt += 3;

         if (currInt > (int) 'z'){
             currInt -=26;
         
         }
         ciphertext += (char) currInt;
         
         }
         
         
  return ciphertext;
      
    }
  
    public static String decode(String plaintext) {
    String ciphertext = "";
    for(int i = 0; i < plaintext.length(); i++){
         char curreChar = plaintext.charAt(i);
         int currInt = (int) curreChar;
         currInt += 23;

         if (currInt > (int) 'z'){
             currInt -=26;
         
         }
         ciphertext += (char) currInt;
         
         }
         
         
  return ciphertext;
      
    }
  

  }


