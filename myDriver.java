public class myDriver{
  public static void main(String[]args){
    WordSearch ws1 = new WordSearch(5, 5);
    System.out.println(ws1.addWordHorizontally("four", 1, 1));
    System.out.println(ws1);
  }
}
