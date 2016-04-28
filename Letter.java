public class Letter{
  private char value;
  private boolean isGuessed;
  
  // constructor that set value to the character and isGuessed to false
  public Letter(char character){
    this.value = character;
    this.isGuessed = false;
  }
  //we call it to return the value from outside this class
  public char getValue(){
    return this.value;
  }
  //returns isGuessed
  public boolean getRevealed(){
    return this.isGuessed;
  }
  //sets isguessed to true
  public void reveal(){
    this.isGuessed = true;
  }
}