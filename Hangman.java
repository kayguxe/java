import java.util.Scanner;

public class Hangman{
  public static void main(String[] args){
    Hangman h = new Hangman("francais");
    h.playGame();
    
    
  }
  private Letter letters[];
  private char[] guesses = new char[8];
  private boolean gameOver = false;
  private int maxNumGuesses;
  private int numGuessesMade;
  boolean incorrect = true;
  private char[] hiddenWord;
  private int counter = 0;
  private String output;
  private String words = "";
  private char correctGuess;
  //first counter that takes the word as input, it store the word inside the words variable to be used later we set the length of the letters and
  //hiddenword to the length of the word and we store every letter in the word in the array letters, we also set the max number of guesses to 8
  public Hangman(String word){
    words = word; 
    int len = word.length();
    letters = new Letter[len];
    hiddenWord = new char[len];
    for(int i =0; i< len; i++){
      letters[i] = new Letter(word.charAt(i));
    }
    this.maxNumGuesses = 8;
  }
  //second constructor; we take the word and the max number of guesses as input
  public Hangman(String word, int maxNum){
    words = word;
    int len = word.length();
    letters = new Letter[len];
    hiddenWord = new char[len];
    for(int i =0; i< len; i++){
      letters[i] = new Letter(word.charAt(i));
    }
    this.maxNumGuesses = maxNum;
  }
  
  
  //while the condition gameover equal false the game should keep going else it check if the player won or lost the game and it return the word both
  //ways
  public void playGame(){
    while(gameOver == false){
      System.out.print("you have made the following guesses: ");
      for(int i=0; i< guesses.length; i++){
        System.out.print(guesses[i] + " ");
      }
      System.out.println();
      displayBoard();
      System.out.println("what is your next guess? ");
      Scanner scanner = new Scanner(System.in);
      char guess = scanner.nextLine().charAt(0);
      guess(guess);
    }
    if(numGuessesMade == maxNumGuesses){
      System.out.println("Game over");
      System.out.print("the word is ");
      for(int j = 0; j < letters.length; j++){
        System.out.print(letters[j].getValue());
      }
      System.out.println(" ");
    }
    else{
      System.out.println("you got the word");
      System.out.print("the word is ");
      for(int j = 0; j < letters.length; j++){
        System.out.print(letters[j].getValue());
      }
      System.out.println(" ");
    }
  }
  //we first check if the guessed character is valid or not if it valid we then check if it's correct or not if its correct we reveal the letter and
  // add the guess to hiddenword array if the guess is incorrect we convert the letter to uppercase then we check if the wrong is already in the guesses
  //array if its not we add it to the guesses array and we increase the number of guesses made by 1, if the number of guesses made equals to the number
  //of max number of guess we set gameOver to true also we check if the word to be guessed equals the guessed word then we set gameOver to true
  private boolean guess(char x){
    if(!(Character.isLetter(x))){
      System.out.println("Invalid guess");
      return false;
    }
    
    else{
      incorrect = true;
      for(int j =0; j< letters.length; j++){
        if((x == letters[j].getValue())){
          letters[j].reveal();
          hiddenWord[j] = x;
          output = new String(hiddenWord);
          incorrect = false;
        }
      }
      if(incorrect == true){
        char xUpper = Character.toUpperCase(x);
        for(int i=0; i< guesses.length; i++){
          if(xUpper == guesses[i]){
            return false;
          }
        }
        guesses[counter] = xUpper;
        counter++;
        numGuessesMade = numGuessesMade + 1; 
      }
      if(numGuessesMade == maxNumGuesses){
        gameOver = true;
      }
      
      if(words.equals(output)){
        
        gameOver = true;
      }
      
      return true; 
    }
  }
  // if the word got revealed we print the correct guess else we print _, we also print the remaining guesses by subtracting numGuessesMade from maxNumGuesses 
  private void displayBoard(){
    System.out.print("word so far: ");
    for(int i =0; i< letters.length; i++){
      if(letters[i].getRevealed() == true){
        correctGuess = Character.toUpperCase(letters[i].getValue());        
        System.out.print(" "+ correctGuess + " ");
      }
      else{
        System.out.print(" _ ");
      }
    }
    System.out.println(" ");
    System.out.println("you have "+(maxNumGuesses - numGuessesMade) + " remaining guesses");
  }
} 