import java.util.*;
import java.io.*;

public class KeywordExtractor {
  public static void main(String[] args) {
    String dir = args[0]; // name of directory with input files
    HashMap<String, Integer> dfs;
    HashMap<String, Integer> tfs;
    String x = "";
    int nDocs = 40;
    dfs = readDocumentFrequencies("freqs.txt");
    for(int i =1; i <= nDocs; i++){
      x = dir  +"/"+ i + ".txt";  
      tfs = computeTermFrequencies(x);
      computeTFIDF(tfs, tfs, nDocs);
      System.out.println(x);
      printTopKeywords(computeTFIDF(tfs, dfs, nDocs), 5);
    }
  }
  //reads the contents of the indicated file and returns a HashMap<String, Integer> containing the term frequencies of words in the file
  public static HashMap<String, Integer> computeTermFrequencies(String filename) {
    HashMap<String, Integer> values = new HashMap<String, Integer>();
    String s = "";
    String value = "";
    int n = 0;
    try {
      FileReader in = new FileReader(filename);
      Scanner sc = new Scanner(in);
      while(sc.hasNextLine()){
        s = sc.nextLine();
        //split the words by space and store them in array
        String[] array = s.split(" ");
        for(int j =0; j < array.length; j++){
          value = array[j];
          value =  DocumentFrequency.normalize(value);
          if(!(value.equals(""))){
            //put the word and its frequency in the file in values hashmap
            if(values.containsKey(value)){
              n = values.get(value);
              values.put(value, ++n);
            }
            else{
              values.put(value, 1);
              
            }
          }
        }
      }
      
    }
    catch (FileNotFoundException fnfe) { 
      fnfe.printStackTrace();
    }
    catch (Exception e) {
      System.err.print(e);
    }
    return values;
    
    
  }
  
  
  //This method reads a frequency file (freqs.txt)
  public static HashMap<String, Integer> readDocumentFrequencies(String filename) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String s = "";
    String word = "";
    int t = 0;
    try{
      Scanner sc = new Scanner(new File(filename));
      while(sc.hasNextLine()){
        s = sc.nextLine();
        String[] array = s.split("\t");
        word = array[0];
        t = Integer.parseInt(array[1]);
        //increase the counting by 1 for every time the key is found in map
        if(map.containsKey(word)){
          map.put(word, map.get(word)+ t);
        }
        else{
          map.put(word, t);
        }
      }
    }
    catch (FileNotFoundException fnfe) { 
      System.err.println(filename+" cannot be found."); 
    }
    catch (Exception e) {
      System.err.print(e);
    }
    return map;
    
    
  }
  
  
  
  public static HashMap<String, Double> computeTFIDF(HashMap<String, Integer> tfs, HashMap<String, Integer> dfs, 
                                                     double nDocs) {
    HashMap<String, Double> map = new HashMap<String, Double>();
    int df = 0;
    Integer valued = 0;
    for (String key : tfs.keySet()) {
      if (!key.equals("")){
        try{
          if(!key.equals(null)){
            df = dfs.get(key);
          }
        }
        catch (Exception en) {
          System.err.print(en);
        }
      }
      valued = tfs.get(key);
      //computing the tfs-dfs for every word in docs and storing it in hashmap map
      Double y = valued * Math.log((nDocs)/df);
      map.put(key, y);
    }
    
    
    
    
    
    
    return map;
  }
  
  /**
   * This method prints the top K keywords by TF-IDF in descending order.
   */
  public static void printTopKeywords(HashMap<String, Double> tfidfs, int k) {
    ValueComparator vc =  new ValueComparator(tfidfs);
    TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(vc);
    sortedMap.putAll(tfidfs);
    
    int i = 0;
    for(Map.Entry<String, Double> entry: sortedMap.entrySet()) {
      String key = entry.getKey();
      Double value = entry.getValue();
      
      System.out.println(key + " " + value);
      i++;
      if (i >= k) {
        break;
      }
    }
  }  
}

/*
 * This class makes printTopKeywords work. Do not modify.
 */
class ValueComparator implements Comparator<String> {
  
  Map<String, Double> map;
  
  public ValueComparator(Map<String, Double> base) {
    this.map = base;
  }
  
  public int compare(String a, String b) {
    if (map.get(a) >= map.get(b)) {
      return -1;
    } else {
      return 1;
    } // returning 0 would merge keys 
  }
}