public class WordSearch{
  private char[][] data;

  public WordSearch(int rows, int cols){
    data = new char[rows][cols];
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
  }

  private void clear(){
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        data[idx][idx2] = '_';
      }
    }
  }

  public String toString(){
    String output = "";
    for (int idx = 0; idx < data.length; idx ++){
      for (int idx2 = 0; idx2 < data[idx].length; idx2 ++){
        output += data[idx][idx2] + " ";
      }
      output += "\n";
    }
    return output;
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
