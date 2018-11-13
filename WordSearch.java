//have addword do all the checks
//have add all words only do the certain
//number of tries per word and then the
//total number of tries until failure
import java.util.*;
import java.io.*;
public class WordSearch{
  private char[][] data;
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;

  public WordSearch(int rows, int cols, String fileName) throws FileNotFoundException{
    data = new char[rows][cols];
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
    //File f = new File(fileName);
    Scanner in = new Scanner(new File(fileName));
    while (in.hasNext()) wordsToAdd.add(in.next());
    //System.out.println(wordsToAdd);
    addAllWords();
  }

  private void clear(){
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
  }

  private boolean addAllWords(){
    int r = 0;
    Random pos = new Random();
    while (!wordsToAdd.isEmpty()){
      addWord(wordsToAdd.get(pos.nextInt(wordsToAdd.size())), r, 0, 0, 1);
      r ++;
    }
    /*Random word = new Random();
    Random ro = new Random();
    Random c = new Random();
    Random rd = new Random(2);
    Random cd = new Random(3);
    int counter = 0;
    while (counter < 50 && !wordsToAdd.isEmpty()){
      for (int idx = 0; idx < 100; idx ++){
        String letters = wordsToAdd.get(word.nextInt(wordsToAdd.size()));
        if (addWord(letters, ro.nextInt(data.length), c.nextInt(data[0].length), rd.nextInt() % 2, cd.nextInt() % 2)){
          wordsAdded.add(letters);
          wordsToAdd.remove(letters);
          counter = 0;
        }
        else counter ++;
      }
    }
    return false;*/
    return true;
  }

  public boolean addWord(String word, int row, int col, int rowIncrement, int colIncrement){
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

  public boolean addWordHorizontal(String word, int row, int col){
    boolean add = false;
    boolean conditional1 = false;
    boolean conditional2 = false;
    boolean conditional3 = true;
    if (row >=0 && col >= 0 && row < data.length)  conditional1 = true;
    if (conditional1 && col <data[row].length && data[row].length - col >= word.length()) conditional2 = true;
    if (conditional1 && conditional2){
      int idx = col;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[row][idx] != '_' && data[row][idx] != word.charAt(wIdx)) conditional3 = false;
        idx ++;
        wIdx ++;
      }
    }
    if (conditional1 && conditional2 && conditional3) add = true;
    if (add){
      int idx = col;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[row][idx] == '_' || data[row][idx] == word.charAt(wIdx)) data[row][idx] = word.charAt(wIdx);
        else return false;
        idx ++;
        wIdx ++;
      }
      return true;
    }
    return false;
  }

  public boolean addWordVertical(String word, int row, int col){
    boolean add = false;
    boolean conditional1 = false;
    boolean conditional2 = false;
    boolean conditional3 = true;
    if (row >=0 && col >= 0 && row < data.length)  conditional1 = true;
    if (conditional1 && col <data[row].length && data.length - row >= word.length()) conditional2 = true;
    if (conditional1 && conditional2){
      int idx = row;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[idx][col] != '_' && data[idx][col] != word.charAt(wIdx)) conditional3 = false;
        idx ++;
        wIdx ++;
      }
    }
    if (conditional1 && conditional2 && conditional3) add = true;
    if (add){
      int idx = row;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[idx][col] == '_' || data[idx][col] == word.charAt(wIdx)){
           data[idx][col] = word.charAt(wIdx);
        }
        else return false;
        idx ++;
        wIdx ++;
      }
      return true;
    }
    return false;
  }

  public boolean addWordDiagonal(String word, int row, int col){
    boolean add = false;
    boolean conditional1 = false;
    boolean conditional2 = false;
    boolean conditional3 = false;
    boolean conditional4 = true;
    if (row >=0 && col >= 0 && row < data.length)  conditional1 = true;
    if (conditional1 && col < data[row].length) conditional2 = true;
    if (conditional2 && data.length - row >= word.length() && data[row].length - col >= word.length()) conditional3 = true;
    if (conditional1 && conditional2 && conditional3){
      int idx = row;
      int idx2 = col;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[idx][idx2] != '_' && data[idx][idx2] != word.charAt(wIdx)) conditional4 = false;
        idx ++;
        idx2 ++;
        wIdx ++;
      }
    }
    if (conditional1 && conditional2 && conditional3) add = true;
    if (add){
      int idx = row;
      int idx2 = col;
      int wIdx = 0;
      while (wIdx < word.length()){
        if (data[idx][idx2] == '_' || data[idx][idx2] == word.charAt(wIdx)){
           data[idx][idx2] = word.charAt(wIdx);
        }
        else return false;
        idx ++;
        idx2 ++;
        wIdx ++;
      }
      return true;
    }
    return false;
  }
}
