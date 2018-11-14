import java.util.*;
import java.io.*;
public class WordSearch{
  private char[][] data;
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;

  public WordSearch(int rows, int cols, String fileName){
    seed = (int)(Math.random()*1000);
    System.out.println("This is your seed: " + seed);
    randgen = new Random(seed);
    data = new char[rows][cols];
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
    try{
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNext()) wordsToAdd.add(in.next().toUpperCase());
      addAllWords();
      printWordsInSearch();

    }catch (FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(0);
    }
  }

  public WordSearch(int rows, int cols, String fileName, int randSeed){
    seed = randSeed;
    System.out.println("This is your seed: " + seed);
    randgen = new Random(randSeed);
    data = new char[rows][cols];
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
    try{
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNext()) wordsToAdd.add(in.next().toUpperCase());
      addAllWords();
      printWordsInSearch();

    }catch (FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(0);
    }
  }

  private void addAllWords(){
    int counter = 0;
    while (!wordsToAdd.isEmpty() && counter < 50){
      boolean added = false;
      int cInc = randgen.nextInt(3) - 1;
      int rInc = randgen.nextInt(3) - 1;
      String letters = wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
      for (int idx = 0; idx < 100 & !added; idx ++){
        int rIdx = randgen.nextInt(data.length);
        int cIdx = randgen.nextInt(data[0].length);
        if (addWord(letters, rIdx, cIdx, rInc, cInc)){
          added = true;
          counter = 0;
        }
      }
      if (!added) counter ++;
    }
  }

  private boolean addWord(String word, int row, int col, int rowIncrement, int colIncrement){
    if (rowIncrement == 0 && colIncrement == 0) return false;
    int rIdx = row;
    int cIdx = col;
    boolean add = false;
    boolean canAdd = true;
    for (int wIdx = 0; wIdx < word.length(); wIdx ++){
      if (rIdx >= 0 && cIdx >= 0 && rIdx < data.length && cIdx < data[0].length){
        if (!(word.charAt(wIdx) == data[rIdx][cIdx] || data[rIdx][cIdx] == '_')) canAdd = false;
        rIdx += rowIncrement;
        cIdx += colIncrement;
      }
      else canAdd = false;
    }
    if (canAdd) add = true;
    if (add){
      rIdx = row;
      cIdx = col;
      for (int wIdx = 0; wIdx < word.length(); wIdx ++){
        data[rIdx][cIdx] = word.charAt(wIdx);
        rIdx += rowIncrement;
        cIdx += colIncrement;
      }
      int pos = wordsToAdd.indexOf(word);
      wordsAdded.add(wordsToAdd.remove(pos));
      return true;
    }
    else return false;
  }

  public String toString(){
    String output = "|";
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        output += data[idx][idx2] + " ";
      }
      output += "|\n|";
    }
    return output.substring(0, output.length() - 1);
  }

  public void printWordsInSearch(){
    String output = "Words: ";
    for (int idx = 0; idx < wordsAdded.size(); idx ++){
      output += wordsAdded.get(idx) + "  ";
    }
    System.out.println(output);
  }

  private void clear(){
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
  }

  //this method isn't going to be used yet,
  //but eventually in order to have a completed
  //wordsearch the rest of the slots need
  //to be filled in with random letters.
  private void fillInLetters(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int rIdx = 0; rIdx < data.length; rIdx ++){
      for (int cIdx = 0; cIdx < data[0].length; cIdx ++){
        if (data[rIdx][cIdx] == '_') data[rIdx][cIdx] = alphabet.charAt(randgen.nextInt(26));
      }
    }
  }

}
