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
    if (row >=0 && col >= 0 && row < data.length)  conditional1 = true;
    if (conditional1 && col <data[row].length && data[row].length - col >= word.length()) conditional2 = true;
    if (conditional1 && conditional2) add = true;
    if (add){
      int idx = col;
      int wordIndex = 0;
      while (wordIndex < word.length()){
        if (data[row][idx] == '_') data[row][idx] = word.charAt(wordIndex);
        else return false;
        idx ++;
        wordIndex ++;
      }
      return true;
    }
    return false;
  }

  public boolean addWordVertical(String word, int row, int col){
    boolean add = false;
    boolean conditional1 = false;
    boolean conditional2 = false;
    if (row >=0 && col >= 0 && row < data.length)  conditional1 = true;
    if (conditional1 && col <data[row].length && data.length - row >= word.length()) conditional2 = true;
    if (conditional1 && conditional2) add = true;
    if (add){
      int idx = row;
      int wordIndex = 0;
      while (wordIndex < word.length()){
        if (data[idx][col] == '_') data[idx][col] = word.charAt(wordIndex);
        else return false;
        idx ++;
        wordIndex ++;
      }
      return true;
    }
    return false;
  }

}
