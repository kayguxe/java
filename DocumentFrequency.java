import java.util.*;
import java.io.*;
import java.util.Arrays;

public class DocumentFrequency {
  
  public static void main(String[] args) {
    String dir = args[0]; // name of directory with input files
    HashMap<String, Integer> dfs;
    dfs = extractDocumentFrequencies(dir, 40);
    writeDocumentFrequencies(dfs, "freqs.txt");
    
  }
  //compute the document frequencies of all of the words in all of the files
  public static HashMap<String, Integer> extractDocumentFrequencies(String directory, int nDocs) {
    String fileName = "";
    int value =0;
    String[] array;
    HashMap<String, Integer> values = new HashMap<String, Integer>();
    HashSet<String> words = new HashSet<String>();
    //go through the files and call extractWordsFromDocument and store the words in words hashset
    for(int i =1; i <= nDocs; i++){
      fileName =  directory + "/" + i + ".txt";
      words = extractWordsFromDocument(fileName);
      array = words.toArray(new String[words.size()]);
      //we put the key and the frequency of all the words in values hashmap
      for(int j =0; j < array.length; j++) {
        String d = array[j];
        if(values.containsKey(d)){
          value = values.get(d);
          values.put(d, ++value);
        }
        else{
          values.put(d, 1);
          
        }
      }
    }
    return values;
  }
  //this method reads a file and returns the words in a hashset
  public static HashSet<String> extractWordsFromDocument(String filename) {
    //hashset to store values in it.  
    HashSet<String> words = new HashSet<String>();
    try{
      String word = "";
      //read file 
      FileReader in = new FileReader(filename);
      Scanner scan = new Scanner(in);
      while (scan.hasNextLine()) {
        String args = scan.nextLine(); 
        //we store the words in array after spliting them by space
        String[] array = args.split(" ");
        //iterate through the array and add them to words hashset
        for(int i = 0; i < array.length; i++){
          word = array[i];
          word = normalize(word);
          if(!word.equals("")){
            words.add(word);
          }
        }
      }
      
    }             
    catch (FileNotFoundException fnfe) { 
      System.err.println(filename+" cannot be found."); 
    } 
    
    return words;
  }
  
  
  public static void writeDocumentFrequencies(HashMap<String, Integer> dfs, String filename) {
    try{
      
      PrintWriter out = new PrintWriter(filename); 
      List<String> list = new ArrayList<String>(dfs.keySet());
      Collections.sort(list);
      
      for(int i =0; i < list.size(); i++){
        out.println(list.get(i)+ "\t" + dfs.get(list.get(i)));
      }
      
      out.close(); 
    }
    catch (FileNotFoundException fnfe) { 
      System.err.println(filename+" cannot be found."); 
    } 
  }
  
  /*
   * This method "normalizes" a word, stripping extra whitespace and punctuation.
   * Do not modify.
   */
  public static String normalize(String word) {
    return word.replaceAll("[^a-zA-Z ']", "").toLowerCase();
  }
  
}